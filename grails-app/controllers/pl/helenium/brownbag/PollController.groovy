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
            def user = User.findById(userIdCookie)
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
            response.setCookie('userId', session.user.id)
            return
        }

        log.info "User not logged in"
    }

    def index() {

    }

    def create() {
        def poll = pollService.create()
        redirect action: 'show', id: poll.id
    }

    def show() {
        assert params.id

        withFormat {
            html {
                render view: 'show'
            }
        } ?: respond(Poll.get(params.id))
    }

    def addIdea() {
        pollService.addIdea(params.id, new Idea(request.JSON))
        render "OK"
    }

    def voteIdea() {
        pollService.voteIdea(params.id, request.JSON.ideaId, session.user)
        render "OK"
    }

}
