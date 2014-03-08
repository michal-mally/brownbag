brownbag.controller('PollListCtrl', function ($scope, $location, authService, pollService) {
    authService.getLoggedInUser().success(function (data) {
        $scope.user = data;
    });

    $scope.createPoll = function () {
        pollService.createPoll().success(function (pollId) {
            $location.path('/' + pollId);
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
            if(idea.votes[i].id == $scope.user.providerId) {
                return true;
            }
        }

        return false;
    };

    $scope.loadIdeas();
    authService.getLoggedInUser().success(function(data) {
        $scope.user = data
    });
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