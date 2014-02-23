<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Brown Bag</title>
    <meta name="layout" content="brownbag"/>
</head>

<body>
<div class="container">
    <ul class="list-group" ng-controller="IdeaListCtrl">
        <li ng-repeat="idea in ideas" class="list-group-item"><a href="#" ng-click="vote(idea.id)" class="btn btn-success bb-btn-voting">{{idea.votes}} <span
                class="glyphicon glyphicon-thumbs-up"></span></a> <span class="bb-shadow">{{idea.title}}</span> <span
                class="label label-info">{{idea.duration}} min</span></li>
    </ul>
    <script>
        function IdeaListCtrl($scope, $http) {
            $scope.loadIdeas = function() {
                $http.get('list.json').success(function(data) {
                    $scope.ideas = data;
                })
            }

            $scope.vote = function(id) {
                $http.post('vote/' + id + '.json').success(function(data) {
                    $scope.loadIdeas()
                })
            }

            $scope.loadIdeas()
        }
    </script>
</div>
</body>
</html>
