modules = {
    application {
        resource url:'js/application.js'
    }
    brownbag {
        dependsOn 'angular'
        resource url: 'js/angular/modules.js'
        resource url: 'js/angular/services.js'
        resource url: 'js/angular/controllers.js'
    }
}
