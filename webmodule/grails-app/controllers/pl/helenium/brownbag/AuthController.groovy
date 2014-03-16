package pl.helenium.brownbag

class AuthController {

    static allowedMethods = [
            logout: "POST"
    ]

    def user() {
        if(session.user) {
            respond session.user
        } else {
            render 'null'
        }
    }

    def login() {
        session.redirectUri = "/#${params.redirectUri}"
        redirect controller: 'oauth', action: params.id, id: 'authenticate'
    }

    def loginCallback() {
        redirect uri: session.redirectUri
    }

    def logout() {
        response.deleteCookie('userId')
        session.invalidate()

        render 'user logged out'
    }

}
