package pl.helenium.brownbag

class ActivityService {

    void record(User user, String pollId, String type) {
        User.collection.update(
                [
                        _id: user.id
                ],
                [
                        $addToSet: [
                                pollActivities: [
                                        _id     : pollId,
                                        lastTime: new Date().time,
                                        type    : [type]
                                ]
                        ]
                ]
        )
    }

}
