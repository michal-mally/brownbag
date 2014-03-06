brownbag.service('authService', function ($http) {
    return {
        getLoggedInUser: function () {
            return $http.get(_contextPath + '/auth/user.json')
        }
    }
});
