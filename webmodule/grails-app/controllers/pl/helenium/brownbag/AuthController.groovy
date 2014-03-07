package pl.helenium.brownbag

class AuthController {

    def user() {
        respond session.user
    }

}
