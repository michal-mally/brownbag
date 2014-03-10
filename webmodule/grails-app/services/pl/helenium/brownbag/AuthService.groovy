package pl.helenium.brownbag

import grails.converters.JSON

class AuthService {

    User registerUser(String token) {
        def text = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=${token}").getText("UTF-8")
        log.info """Data retrieved for token = ${token}:
${text}"""
        def json = JSON.parse(text)
        new User(
                providerId: json.id,
                email: json.email,
                name: json.name,
                firstname: json.given_name,
                lastname: json.family_name,
        ).save(flush: true, failOnError: true)
    }

}
