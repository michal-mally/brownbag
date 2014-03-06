package pl.helenium.brownbag

class PollService {

    Poll create() {
        new Poll().save(flush: true, failOnError: true)
    }

    void createIdea(String pollId, Idea idea) {
        Poll.collection.update(
                [_id: pollId],
                [
                        $addToSet: [
                                ideas: [
                                        _id: UUID.randomUUID().toString(),
                                        title: idea.title,
                                        location: idea.location,
                                        duration: idea.duration,
                                        creator: idea.creator,
                                        votes: idea.votes,
                                ]
                        ]
                ])
    }

    void voteIdea(String pollId, String ideaId, User user) {
        def poll = Poll.findById(pollId)
        Idea idea = poll.ideas.find { it.id == ideaId }
        assert idea: "idea mustn't be null"

        def userId = new UserId(name: user.name)
        userId.id = user.providerId
        if (idea.votes.every() { it.id != userId.id }) {
            idea.addToVotes(userId)
            poll.$changedProperties['ideas'] = true
            poll.save(flush: true, failOnError: true)
        }
    }

}
