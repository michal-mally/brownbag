import pl.helenium.brownbag.Idea

class BootStrap {

    def init = { servletContext ->
        new Idea(
                title: 'Becoming Productive Groovy/Grails and Spring Developer with IntelliJ IDEA',
                location: 'http://www.infoq.com/presentations/groovy-grails-intellij-idea',
                duration: 79
        ).save()
        new Idea(
                title: 'Advanced Groovy Tips and Tricks',
                location: 'http://www.infoq.com/presentations/advanced-groovy-tips',
                duration: 88
        ).save()
        new Idea(
                title: 'AngularJS, Backbone.js and Client-Centric Design',
                location: 'http://www.youtube.com/watch?v=8NIIc3J7tNc',
                duration: 82
        ).save()
    }

    def destroy = {
    }

}
