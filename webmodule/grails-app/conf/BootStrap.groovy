import grails.converters.JSON
import pl.helenium.brownbag.Idea
import pl.helenium.brownbag.Poll
import pl.helenium.brownbag.UserId

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Poll) { Poll poll ->
            [
                    id: poll.id,
                    ideas: poll.ideas
            ]
        }
        JSON.registerObjectMarshaller(Idea) { Idea idea ->
            [
                    id: idea.id,
                    title: idea.title,
                    location: idea.location,
                    duration: idea.duration,
                    votes: idea.votes,
                    lastVoteTime: idea.lastVoteTime
            ]
        }
        JSON.registerObjectMarshaller(UserId) { UserId userId ->
            [
                    id: userId.id,
                    name: userId.name
            ]
        }
    }

    def destroy = {
    }

}
