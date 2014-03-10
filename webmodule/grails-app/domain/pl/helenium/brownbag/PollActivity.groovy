package pl.helenium.brownbag

class PollActivity {

    String id

    long lastTime

    Set types = []

    static hasMany = [
            types: String
    ]

}
