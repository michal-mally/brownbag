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

    def logout() {
        response.deleteCookie('userId')
        session.invalidate()

        render 'user logged out'
    }

}
