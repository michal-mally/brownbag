package pl.helenium.brownbag

import org.bson.types.ObjectId

class Poll {

    ObjectId id

    static hasMany = [ideas: Idea]

    static embedded = ['ideas']

}
