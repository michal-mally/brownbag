package pl.helenium.brownbag

import org.bson.types.ObjectId

class PollController {

    def index() {

    }

    def create() {
        def poll = new Poll().save(flush: true, failOnError: true)
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
        def poll = Poll.get(new ObjectId(params.id))
        def idea = new Idea(request.JSON)
        poll.addToIdeas(idea)
        poll.save()

        render "OK"
    }

}
