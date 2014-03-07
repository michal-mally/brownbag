modules = {
    application {
        resource url:'js/application.js'
    }
    brownbag {
        dependsOn 'angular', 'angular-route'
        resource url: 'js/angular/modules.js'
        resource url: 'js/angular/services.js'
        resource url: 'js/angular/controllers.js'
        resource url: 'js/angular/routes.js'
    }
}
