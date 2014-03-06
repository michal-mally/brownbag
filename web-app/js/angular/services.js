brownbag.service('authService', function($http) {
    var getLoggedInUser = function(scope) {
        $http.get(_contextPath + '/auth/user.json').success(function(data) {
                scope.user = data
            }
        )
    };

    return {
        getLoggedInUser: getLoggedInUser
    }
});
