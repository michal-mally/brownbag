import grails.converters.JSON
import pl.helenium.brownbag.Idea
import pl.helenium.brownbag.Poll
import pl.helenium.brownbag.PollActivity
import pl.helenium.brownbag.User
import pl.helenium.brownbag.UserId

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Poll) { Poll poll ->
            [
                    id   : poll.id,
                    ideas: poll.ideas,
            ]
        }
        JSON.registerObjectMarshaller(Idea) { Idea idea ->
            [
                    id          : idea.id,
                    title       : idea.title,
                    location    : idea.location,
                    duration    : idea.duration,
                    votes       : idea.votes,
                    lastVoteTime: idea.lastVoteTime,
            ]
        }
        JSON.registerObjectMarshaller(User) { User user ->
            [
                    id  : user.id,
                    name: user.name,
            ]
        }
        JSON.registerObjectMarshaller(UserId) { UserId userId ->
            [
                    id  : userId.id,
                    name: userId.name,
            ]
        }
        JSON.registerObjectMarshaller(PollActivity) { PollActivity activity ->
            [
                    id      : activity.id,
                    lastTime: activity.lastTime,
                    types   : activity.types,
            ]
        }
    }

    def destroy = {
    }

}
