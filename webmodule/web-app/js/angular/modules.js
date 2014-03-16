angular.module("brownbag", ["ngRoute"]);

var brownbag = angular.module("brownbag");

brownbag.run(function($rootScope, $location) {
    $rootScope.location = $location;
});
