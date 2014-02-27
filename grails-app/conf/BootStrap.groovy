import grails.converters.JSON
import org.bson.types.ObjectId
import pl.helenium.brownbag.Idea
import pl.helenium.brownbag.Poll

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(ObjectId) {
            it.toStringMongod()
        }
        JSON.registerObjectMarshaller(Poll) { Poll poll ->
            [
                    id: poll.id,
                    ideas: poll.ideas
            ]
        }
        JSON.registerObjectMarshaller(Idea) { Idea idea ->
            [
                    title: idea.title,
                    location: idea.location,
                    duration: idea.duration,
                    votes: idea.votes
            ]
        }
    }

    def destroy = {
    }

}
