brownbag.service('authService', function ($http) {
    return {
        getLoggedInUser: function () {
            return $http.get(_contextPath + '/auth/user.json')
        }
    }
});

brownbag.service('pollService', function ($http) {
    return {
        createPoll: function() {
            return $http.post(_contextPath + '/poll/create.json')
        },
        getPoll: function (pollId) {
            return $http.get(_contextPath + '/poll/show/' + pollId + '.json')
        },
        createIdea: function(pollId, idea) {
            return $http.post(_contextPath + '/poll/createIdea/' + pollId, idea)
        },
        voteIdea: function (pollId, ideaId) {
            return $http.post(_contextPath + '/poll/voteIdea/' + pollId, {ideaId: ideaId})
        }
    }
});
