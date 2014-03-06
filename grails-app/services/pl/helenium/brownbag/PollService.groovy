package pl.helenium.brownbag

class PollService {

    Poll create() {
        new Poll().save(flush: true, failOnError: true)
    }

    void createIdea(String pollId, Idea idea) {
        def poll = Poll.findById(pollId)
        idea.id = UUID.randomUUID().toString()
        poll.addToIdeas(idea)
        poll.save()
    }

    void voteIdea(String pollId, String ideaId, User user) {
        def poll = Poll.findById(pollId)
        Idea idea = poll.ideas.find { it.id == ideaId }
        assert idea : "idea mustn't be null"

        def userId = new UserId(name: user.name)
        userId.id = user.providerId
        if (idea.votes.every() { it.id != userId.id}) {
            idea.addToVotes(userId)
            poll.$changedProperties['ideas'] = true
            poll.save(flush: true, failOnError: true)
        }
    }

}
