package pl.helenium.brownbag

class ActivityService {

    void recordActivity(User user, String pollId, String type) {
        if (!user) {
            return
        }

        UserActivity.collection.update(
                [
                        _id        : user.id,
                        'polls._id': [$ne: pollId]
                ],
                [
                        $push: [
                                polls: [
                                        _id: pollId,
                                ]
                        ]
                ],
                true
        )
        UserActivity.collection.update(
                [
                        _id        : user.id,
                        'polls._id': pollId,
                ],
                [
                        $set     : [
                                'polls.$.lastTime': new Date().time,
                        ],
                        $addToSet: [
                                'polls.$.types': type,
                        ]
                ]
        )
    }

}
