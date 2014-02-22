package pl.helenium.brownbag

class Idea {

    String title

    String location

    Long duration

    static constraints = {
        title blank: false
        location blank: false, url: true
        duration min: 1L
    }

}