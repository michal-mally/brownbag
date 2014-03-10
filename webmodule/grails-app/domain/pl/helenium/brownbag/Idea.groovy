package pl.helenium.brownbag

class Idea {

    String id

    String title

    String location

    Long duration

    UserId creator

    Set votes = []

    long lastVoteTime

    static constraints = {
        title blank: false
        location blank: false, url: true
        duration min: 1L
    }

    static hasMany = [votes: UserId]

    static embedded = ['votes']

}
