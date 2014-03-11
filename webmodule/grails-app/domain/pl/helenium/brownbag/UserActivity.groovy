package pl.helenium.brownbag

class UserActivity {

    String id

    Set polls = []

    static hasMany = [
            polls: PollActivity
    ]

    static embedded = ['polls']

    static mapping = {
        version false
    }

}
