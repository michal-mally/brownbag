package pl.helenium.brownbag

class ActivityService {

    void recordActivity(User user, String pollId, String type) {
        if (!user) {
            return
        }

        User.collection.update(
                [
                        _id                 : user.id,
                        'pollActivities._id': [$ne: pollId]
                ],
                [
                        $push: [
                                pollActivities: [
                                        _id: pollId,
                                ]
                        ]
                ]
        )
        User.collection.update(
                [
                        _id                 : user.id,
                        'pollActivities._id': pollId,
                ],
                [
                        $set     : [
                                'pollActivities.$.lastTime': new Date().time,
                        ],
                        $addToSet: [
                                'pollActivities.$.types': type,
                        ]
                ]
        )
    }

}
