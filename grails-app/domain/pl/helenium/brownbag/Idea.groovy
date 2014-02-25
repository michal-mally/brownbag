package pl.helenium.brownbag

import org.bson.types.ObjectId

class Idea {

    ObjectId id

    String title

    String location

    Long duration

    String creatorId

    Set votes = []

    static constraints = {
        title blank: false
        location blank: false, url: true
        duration min: 1L
    }

    static hasMany = [votes: String]

}
