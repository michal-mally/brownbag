brownbag.controller('AuthCtrl', function ($scope, authService) {
    $scope.user = null;

    authService.getLoggedInUser().success(function(data) {
        if (data != 'null') {
            $scope.user = data;
        } else {
            $scope.user = null;
        }
    });

    $scope.logout = function() {
        authService.logout().success(function(data) {
            $scope.user = null;
        });
    };
});

brownbag.controller('PollListCtrl', function ($scope, $location, authService, pollService) {
    pollService.getPollActivities().success(function(data) {
        $scope.pollActivities = data;
    });

    $scope.createPoll = function () {
        pollService.createPoll().success(function (poll) {
            $location.path('/' + poll.id);
        });
    };
});

brownbag.controller('PollCtrl', function ($scope, $http, $location, $routeParams, pollService, authService) {
    $scope.ideasShown = 5;
    $scope.pollId = $routeParams.pollId;

    $scope.loadIdeas = function () {
        pollService.getPoll($scope.pollId).success(function (data) {
            $scope.ideas = data.ideas;
        });
    };

    $scope.createIdea = function () {
        $location.path($location.path() + '/idea/create');
    };

    $scope.voteIdea = function (ideaId) {
        pollService.voteIdea($scope.pollId, ideaId).success(function (data) {
            $scope.loadIdeas()
        });
    };

    $scope.showMore = function () {
        $scope.ideasShown += 5;
    };

    $scope.hasVoted = function (idea) {
        for(var i = 0; i < idea.votes.length; i++) {
            if(idea.votes[i].id == $scope.user.id) {
                return true;
            }
        }

        return false;
    };

    $scope.loadIdeas();
});

brownbag.controller('IdeaCtrl', function ($scope, $routeParams, $location, pollService) {
    $scope.pollId = $routeParams.pollId;

    $scope.create = function (idea) {
        pollService.createIdea($scope.pollId, idea).success(function (data) {
            $location.path('/' + $scope.pollId);
        });
    };

    $scope.cancel = function () {
        $location.path('/' + $scope.pollId);
    };
});
