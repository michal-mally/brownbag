import grails.converters.JSON
import pl.helenium.brownbag.Idea
import pl.helenium.brownbag.Poll
import pl.helenium.brownbag.PollActivity
import pl.helenium.brownbag.User
import pl.helenium.brownbag.UserActivity
import pl.helenium.brownbag.UserId

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Poll) { Poll poll ->
            [
                    id   : poll.id,
                    name : poll.name,
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
        JSON.registerObjectMarshaller(UserActivity) { UserActivity user ->
            [
                    id   : user.id,
                    polls: user.polls
            ]
        }
        JSON.registerObjectMarshaller(PollActivity) { PollActivity poll ->
            [
                    id      : poll.id,
                    lastTime: poll.lastTime,
                    types   : poll.types,
            ]
        }
    }

    def destroy = {
    }

}
