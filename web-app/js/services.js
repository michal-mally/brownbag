angular.module("brownbag", []);

angular.module("brownbag").service('authService', function($http) {
    var getLoggedInUser = function(scope) {
        $http.get(_contextPath + '/auth/user.json').success(function(data) {
                scope.user = data
            }
        )
    };

    return {
        getLoggedInUser: getLoggedInUser
    }
}).controller('IdeaListCtrl', function($scope, $http) {
    $scope.ideasShown = 5;

    $scope.loadIdeas = function () {
        $http.get(_contextPath + '/' + _pollId + '.json').success(function (data) {
            $scope.ideas = data.ideas;
        })
    };

    $scope.voteIdea = function (id) {
        $http.post(_contextPath + '/poll/voteIdea/' + _pollId, {ideaId: id}).success(function (data) {
            $scope.loadIdeas()
        })
    };

    $scope.addIdea = function (idea) {
        $http.post(_contextPath + '/poll/addIdea/' + _pollId, idea).success(function (data) {
            $scope.loadIdeas();
            $scope.editPanelShown = false;
            $scope.message = "Dodano nowy pomysł";
            $scope.messageType = "success"
        })
    };

    $scope.showMore = function () {
        if ($scope.ideasShown <= $scope.ideas.length) {
            $scope.ideasShown += 5;
        }
    };

    $scope.showLess = function () {
        $scope.ideasShown = Math.max($scope.ideasShown - 5, 5)
    };

    $scope.hasVoted = function (idea) {
        return idea.votes.indexOf(getCookie('userId')) != -1
    };

    $scope.loadIdeas();
}).controller('PollsCtrl', function($scope, authService) {
    authService.getLoggedInUser($scope)
});
