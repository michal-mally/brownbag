brownbag.controller('PollCtrl', function($scope, $http, pollService) {
    $scope.ideasShown = 5;

    $scope.loadIdeas = function () {
        pollService.getPoll(_pollId).success(function (data) {
            $scope.ideas = data.ideas;
        })
    };

    $scope.addIdea = function (idea) {
        pollService.addIdea(_pollId, idea).success(function (data) {
            $scope.loadIdeas();
            $scope.editPanelShown = false;
            $scope.message = "Dodano nowy pomysł";
            $scope.messageType = "success"
        })
    };

    $scope.voteIdea = function (ideaId) {
        pollService.voteIdea(_pollId, ideaId).success(function (data) {
            $scope.loadIdeas()
        })
    };

    $scope.showMore = function () {
        $scope.ideasShown += 5;
    };

    $scope.hasVoted = function (idea) {
        return idea.votes.indexOf(getCookie('userId')) != -1
    };

    $scope.loadIdeas();
});

brownbag.controller('HomeCtrl', function($scope, authService) {
    authService.getLoggedInUser().success(function(data) {
        $scope.user = data;
    });
});
