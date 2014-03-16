package pl.helenium.brownbag.oauth.two

import groovy.json.JsonSlurper
import org.scribe.extractors.AccessTokenExtractor
import org.scribe.model.Token

class GoogleAccessTokenExtractor implements AccessTokenExtractor {

    @Override
    Token extract(String response) {
        String token = new JsonSlurper().parseText(response).access_token
        new Token(token, "", response)
    }

}
