package pl.helenium.brownbag

import java.util.concurrent.ThreadLocalRandom

class Idea {

    String title

    String location

    Long duration

    long votes = ThreadLocalRandom.current().nextInt(0, 100)

    static constraints = {
        title blank: false
        location blank: false, url: true
        duration min: 1L
    }

}
