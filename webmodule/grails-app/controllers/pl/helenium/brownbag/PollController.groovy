package pl.helenium.brownbag

import org.scribe.model.Token

class PollController {

    def pollService

    def oauthService

    def authService

    def activityService

    def beforeInterceptor = {
        if (user) {
            log.info "User already in session: $user"
            return
        }

        def userIdCookie = request.getCookie('userId')
        if (userIdCookie) {
            log.info "User id cookie: ${userIdCookie}"
            def userByBrownbagId = User.findByBrownbagId(userIdCookie)
            if (userByBrownbagId) {
                user = userByBrownbagId
                return
            } else {
                response.deleteCookie('userId')
                log.warn("Cookie user id invalid: $userIdCookie")
            }
        }

        Token accessToken = session[oauthService.findSessionKeyForAccessToken('google')]
        if (accessToken) {
            log.info "User not in session but Google Access Token: $accessToken"
            user = authService.registerUser(accessToken.token)
            response.setCookie('userId', user.brownbagId)
            return
        }

        log.info "User not logged in"
        if (actionName in ['index', 'show']) {
            log.info("It is OK not to be logged in for action: $actionName")
            return
        }

        throw new RuntimeException("User has to be logged in for action: ${actionName}")
    }

    def index() {

    }

    def create() {
        def pollName = request.JSON.name
        assert pollName : "Poll name mustn't be empty!"

        def poll = pollService.createPoll(user, pollName)
        activityService.recordActivity(user, poll.id, 'create')
        respond poll
    }

    def show() {
        def poll = Poll.findById(params.id)
        activityService.recordActivity(user, poll.id, 'show')
        respond poll
    }

    def createIdea() {
        pollService.createIdea(params.id, new Idea(request.JSON))
        activityService.recordActivity(user, params.id, 'createIdea')
        render "OK"
    }

    def voteIdea() {
        pollService.voteIdea(params.id, request.JSON.ideaId, user)
        activityService.recordActivity(user, params.id, 'voteIdea')
        render "OK"
    }

    def showUserActivity() {
        respond UserActivity.findById(user.id)
    }

    private User getUser() {
        session.user
    }

    private void setUser(User user) {
        session.user = user
    }

}
