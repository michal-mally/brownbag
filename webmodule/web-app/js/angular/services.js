brownbag.service('authService', function ($http) {
    var getLoggedInUser = function () {
        return $http.get('auth/user.json');
    };

    var logout = function() {
        return $http.post('auth/logout');
    };

    return {
        getLoggedInUser: getLoggedInUser,
        logout: logout
    };
});

brownbag.service('pollService', function ($http) {
    return {
        createPoll: function(poll) {
            return $http.post('poll/create.json', poll);
        },
        getPoll: function (pollId) {
            return $http.get('poll/show/' + pollId + '.json');
        },
        createIdea: function(pollId, idea) {
            return $http.post('poll/createIdea/' + pollId, idea);
        },
        voteIdea: function (pollId, ideaId) {
            return $http.post('poll/voteIdea/' + pollId, {ideaId: ideaId});
        },
        revokeVote: function (pollId, ideaId) {
            return $http.post('poll/revokeVote/' + pollId, {ideaId: ideaId});
        },
        getUserActivity: function() {
            return $http.get('poll/showUserActivity.json');
        }
    }
});
