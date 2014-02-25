package pl.helenium.brownbag

import org.bson.types.ObjectId

class IdeaController {

    def index() {
        render view: 'index'
        linkUserByCookie()
    }

    def list() {
        respond Idea.list().sort { it.votes.size() }
    }

    def save() {
        new Idea(request.JSON).with {
            creatorId = getUserId()
            save(validate: true)
        }
        render "OK"
    }

    def vote() {
        def userId = getUserId()
        assert userId : "userId mustn't be null!"

        def idea = Idea.get(new ObjectId(params.id))
        assert idea : "idea mustn't be null"

        if (!idea.votes.contains(userId)) {
            idea.addToVotes(userId)
            idea.save()
        }
        render "OK"
    }

    private void linkUserByCookie() {
        if(!getUserId()) {
            response.setCookie('userId', UUID.randomUUID().toString())
        }
    }

    private String getUserId() {
        request.getCookie('userId')
    }

}
