package pl.helenium.brownbag.oauth.two

import org.scribe.builder.api.DefaultApi20
import org.scribe.extractors.AccessTokenExtractor
import org.scribe.model.OAuthConfig
import org.scribe.model.Verb
import org.scribe.oauth.OAuthService

import static java.net.URLEncoder.encode
import static org.scribe.model.Verb.POST

class GoogleApi20 extends DefaultApi20 {

    @Override
    String getAccessTokenEndpoint() {
        "https://accounts.google.com/o/oauth2/token"
    }

    @Override
    Verb getAccessTokenVerb() {
        POST
    }

    @Override
    OAuthService createService(OAuthConfig config) {
        new GoogleOAuth20Service(this, config)
    }

    @Override
    AccessTokenExtractor getAccessTokenExtractor() {
        new GoogleAccessTokenExtractor()
    }

    @Override
    String getAuthorizationUrl(OAuthConfig config) {
        "https://accounts.google.com/o/oauth2/auth?" +
                "response_type=code&" +
                "scope=${encode(config.scope)}&" +
                "redirect_uri=${encode(config.callback)}&" +
                "client_id=${encode(config.apiKey)}"
    }

}
