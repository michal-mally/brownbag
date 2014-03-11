package pl.helenium.brownbag

class PollActivity {

    String id

    String name

    long lastTime

    Set types = []

    static hasMany = [
            types: String
    ]

    static embedded = ['types']

}
