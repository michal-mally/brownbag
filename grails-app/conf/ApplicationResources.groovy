modules = {
    application {
        resource url:'js/application.js'
    }
    brownbag {
        dependsOn 'angular'
        resource url: 'js/services.js'
    }
}
