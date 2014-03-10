package pl.helenium.brownbag

class User {

    String id

    String brownbagId

    String email

    String name

    String firstname

    String lastname

    Set pollActivities = []

    static hasMany = [
            pollActivities: PollActivity
    ]

    static embedded = ['pollActivities']

    static mapping = {
        version false
    }

}
