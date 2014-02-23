package pl.helenium.brownbag
import grails.transaction.Transactional

class IdeaController {

    def index() {
        render view: 'index'
        linkUserByCookie()
    }

    def list() {
        respond Idea.listOrderByVotes(order: 'desc')
    }

    @Transactional
    def save() {
        new Idea(request.JSON).save()
        render "OK"
    }

    @Transactional
    def vote() {
        def userId = getUserId()
        assert userId : "userId mustn't be null!"

        def idea = Idea.get(params.id)
        assert idea : "idea mustn't be null"

        def vote = Vote.findByIdeaAndUserId(idea, userId)
        if (!vote) {
            idea.votes++
            new Vote(idea: idea, userId: userId).save()
            render "OK"
        } else {
            render "DUPLICATE"
        }
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
