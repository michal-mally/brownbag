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
                                        _id     : UUID.randomUUID().toString(),
                                        title   : idea.title,
                                        location: idea.location,
                                        duration: idea.duration,
                                        creator : idea.creator,
                                        votes   : idea.votes,
                                ]
                        ]
                ])
    }

    void voteIdea(String pollId, String ideaId, User user) {
        Poll.collection.update(
                [_id: pollId, 'ideas._id': ideaId],
                [
                        $addToSet: [
                                'ideas.$.votes': [
                                        _id : user.providerId,
                                        name: user.name
                                ]
                        ]
                ]
        )
    }

}
