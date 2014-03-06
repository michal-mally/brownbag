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

brownbag.controller('PollCtrl', function ($scope, $http, $location, $routeParams, pollService) {
    $scope.ideasShown = 5;
    $scope.pollId = $routeParams.pollId;

    $scope.loadIdeas = function () {
        pollService.getPoll($scope.pollId).success(function (data) {
            $scope.ideas = data.ideas;
        });
    };

    $scope.addIdea = function () {
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
        return idea.votes.indexOf(getCookie('userId')) != -1
    };

    $scope.loadIdeas();
});

brownbag.controller('IdeaCtrl', function ($scope, $routeParams, $location, pollService) {
    $scope.pollId = $routeParams.pollId;

    $scope.create = function (idea) {
        pollService.addIdea($scope.pollId, idea).success(function (data) {
            $location.path('/' + $scope.pollId);
        });
    };

    $scope.cancel = function () {
        $location.path('/' + $scope.pollId);
    };
});
