<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Brown Bag</title>
    <meta name="layout" content="brownbag"/>
</head>

<body>
<div class="container">
    <ul class="list-group" ng-controller="IdeaListCtrl">
        <li ng-repeat="idea in ideas" class="list-group-item"><a href="#" class="btn btn-success bb-btn-voting">{{idea.votes}} <span
                class="glyphicon glyphicon-thumbs-up"></span></a> <span class="bb-shadow">{{idea.title}}</span> <span
                class="label label-info">{{idea.duration}} min</span></li>
    </ul>
    <script>
        function IdeaListCtrl($scope, $http) {
            $http.get('list.json').success(function(data) {
                $scope.ideas = data;
            });
        }
    </script
</div>
</body>
</html>
