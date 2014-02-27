package pl.helenium.brownbag

import org.bson.types.ObjectId

class PollController {

    def pollService

    def index() {
        linkUserByCookie()
        render view: 'index'
    }

    def create() {
        def poll = pollService.create()
        redirect action: 'show', id: poll.id.toStringMongod()
    }

    def show() {
        assert params.id

        withFormat {
            html {
                render view: 'show'
            }
        } ?: respond(Poll.get(new ObjectId(params.id)))
    }

    def addIdea() {
        pollService.addIdea(params.id, new Idea(request.JSON))
        render "OK"
    }

    def voteIdea() {
        pollService.voteIdea(params.id, request.JSON.ideaId, getUserId())
        render "OK"
    }

    private void linkUserByCookie() {
        if(!getUserId()) {
            response.setCookie('userId', getUserId())
        }
    }

    private String getUserId() {
        request.getCookie('userId')
    }

}
