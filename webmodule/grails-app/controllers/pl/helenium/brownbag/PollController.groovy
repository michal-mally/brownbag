package pl.helenium.brownbag

import org.scribe.model.Token

class PollController {

    def pollService

    def oauthService

    def authService

    def beforeInterceptor = {
        if (session.user) {
            log.info "User already in session: $session.user"
            return
        }

        def userIdCookie = request.getCookie('userId')
        if (userIdCookie) {
            log.info "User id cookie: ${userIdCookie}"
            def user = User.findByBrownbagId(userIdCookie)
            if (user) {
                session.user = user
                return
            } else {
                response.deleteCookie('userId')
                log.warn("Cookie user id invalid: $userIdCookie")
            }
        }

        Token accessToken = session[oauthService.findSessionKeyForAccessToken('google')]
        if (accessToken) {
            log.info "User not in session but Google Access Token: $accessToken"
            session.user = authService.registerUser(accessToken.token)
            response.setCookie('userId', session.user.brownbagId)
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
        render pollService.create().id
    }

    def show() {
        respond(Poll.get(params.id))
    }

    def createIdea() {
        pollService.createIdea(params.id, new Idea(request.JSON))
        render "OK"
    }

    def voteIdea() {
        pollService.voteIdea(params.id, request.JSON.ideaId, session.user)
        render "OK"
    }

}
