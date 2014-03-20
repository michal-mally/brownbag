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

    $scope.me = function(user) {
        return $scope.user.id == user.id;
    };

    $scope.notMe = function(user) {
        return $scope.user.id != user.id;
    };
});

brownbag.controller('PollListCtrl', function ($scope, $location, authService, pollService) {
    pollService.getUserActivity().success(function(data) {
        $scope.userActivity = data;
    });

    $scope.createPoll = function (poll) {
        pollService.createPoll(poll).success(function (poll) {
            $location.path('/' + poll.id);
        });
    };

    $scope.hasType = function (poll, type) {
        return poll.types.indexOf(type) != -1;
    }
});

brownbag.controller('PollCtrl', function ($scope, $http, $location, $routeParams, $timeout, pollService) {
    $scope.ideasShown = 10;
    $scope.votesShown = 10;
    $scope.pollId = $routeParams.pollId;
    $scope.frozen = false;

    $scope.loadPoll = function () {
        pollService.getPoll($scope.pollId).success(function (data) {
            $scope.poll = data;
        });
    };

    $scope.createIdea = function () {
        $location.path($location.path() + '/idea/create');
    };

    $scope.voteIdea = function (ideaId) {
        pollService.voteIdea($scope.pollId, ideaId).success(function (data) {
            $scope.loadPoll();
            $scope.frozen = true;
            $timeout(function() { $scope.frozen = false }, 700);
        });
    };

    $scope.revokeVote = function (ideaId) {
        pollService.revokeVote($scope.pollId, ideaId).success(function (data) {
            $scope.loadPoll();
            $scope.frozen = true;
            $timeout(function() { $scope.frozen = false }, 700);
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

    $scope.loadPoll();
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
