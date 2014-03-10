package pl.helenium.brownbag

class Poll {

    String id

    UserId creator

    Set ideas = []

    static hasMany = [ideas: Idea]

    static embedded = ['ideas']

    static mapping = {
        version false
    }

}
