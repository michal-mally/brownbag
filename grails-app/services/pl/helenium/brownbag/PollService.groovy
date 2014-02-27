package pl.helenium.brownbag

import org.bson.types.ObjectId

class PollService {

    Poll create() {
        new Poll().save(flush: true, failOnError: true)
    }

    void addIdea(String pollId, Idea idea) {
        def poll = Poll.get(new ObjectId(pollId))
        idea.id = new ObjectId()
        poll.addToIdeas(idea)
        poll.save()
    }

    void voteIdea(String pollId, String ideaId, String userId) {
        def poll = Poll.get(new ObjectId(pollId))
        def idea = poll.ideas.find { it.id == new ObjectId(ideaId) }
        assert idea : "idea mustn't be null"

        if (!idea.votes.contains(userId)) {
            idea.addToVotes(userId)
            poll.$changedProperties['ideas'] = true
            poll.save(flush: true, failOnError: true)
        }
    }

}
