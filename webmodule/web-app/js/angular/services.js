brownbag.service('authService', function ($http) {
    var getLoggedInUser = function () {
        return $http.get(_contextPath + '/auth/user.json');
    };

    var logout = function() {
        return $http.post(_contextPath + '/auth/logout');
    };

    return {
        getLoggedInUser: getLoggedInUser,
        logout: logout
    };
});

brownbag.service('pollService', function ($http) {
    return {
        createPoll: function(poll) {
            return $http.post(_contextPath + '/poll/create.json', poll);
        },
        getPoll: function (pollId) {
            return $http.get(_contextPath + '/poll/show/' + pollId + '.json');
        },
        createIdea: function(pollId, idea) {
            return $http.post(_contextPath + '/poll/createIdea/' + pollId, idea);
        },
        voteIdea: function (pollId, ideaId) {
            return $http.post(_contextPath + '/poll/voteIdea/' + pollId, {ideaId: ideaId});
        },
        getUserActivity: function() {
            return $http.get(_contextPath + '/poll/showUserActivity.json');
        }
    }
});
