package pl.helenium.brownbag

class PollService {

    Poll createPoll(User user, String title) {
        def pollId = UUID.randomUUID().toString()
        Poll.collection.insert(
                [
                        _id    : pollId,
                        name   : title,
                        creator: [
                                _id : user.id,
                                name: user.name,
                        ]
                ]
        )
        Poll.findById(pollId)
    }

    void createIdea(String pollId, Idea idea) {
        Poll.collection.update(
                [_id: pollId],
                [
                        $addToSet: [
                                ideas: [
                                        _id         : UUID.randomUUID().toString(),
                                        title       : idea.title,
                                        location    : idea.location,
                                        duration    : idea.duration,
                                        creator     : idea.creator,
                                        votes       : idea.votes,
                                        lastVoteTime: new Date().time,
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
                                        _id : user.id,
                                        name: user.name
                                ]
                        ],
                        $set     : [
                                'ideas.$.lastVoteTime': new Date().time
                        ]
                ])
    }

    void revokeVote(String pollId, String ideaId, User user) {
        Poll.collection.update(
                [_id: pollId, 'ideas._id': ideaId],
                [
                        $pull: [
                                'ideas.$.votes': [_id: user.id]
                        ]
                ]
        )
    }

}
