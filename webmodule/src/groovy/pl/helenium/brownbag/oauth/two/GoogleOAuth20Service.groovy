package pl.helenium.brownbag.oauth.two

import org.scribe.builder.api.DefaultApi20
import org.scribe.model.*
import org.scribe.oauth.OAuth20ServiceImpl

import static org.scribe.model.OAuthConstants.*

class GoogleOAuth20Service extends OAuth20ServiceImpl {

    private final DefaultApi20 googleApi

    private final OAuthConfig googleConfig

    GoogleOAuth20Service(DefaultApi20 api, OAuthConfig config) {
        super(api, config)
        this.googleApi = api
        this.googleConfig = config
    }

    @Override
    Token getAccessToken(Token requestToken, Verifier verifier) {
        Response response = new OAuthRequest(googleApi.accessTokenVerb, googleApi.accessTokenEndpoint).with {
            addBodyParameter(CLIENT_ID, googleConfig.apiKey)
            addBodyParameter(CLIENT_SECRET, googleConfig.apiSecret)
            addBodyParameter(CODE, verifier.value)
            addBodyParameter(REDIRECT_URI, googleConfig.callback)
            addBodyParameter("grant_type", "authorization_code")
            if (googleConfig.hasScope()) {
                addBodyParameter(SCOPE, googleConfig.scope)
            }

            send()
        }

        googleApi.accessTokenExtractor.extract(response.body)
    }

}
