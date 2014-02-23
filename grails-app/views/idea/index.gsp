<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Brown Bag</title>
    <meta name="layout" content="brownbag"/>
</head>

<body>
<div class="container" ng-controller="IdeaListCtrl">
    <ul class="list-group">
        <li ng-repeat="idea in ideas" class="list-group-item"><a href="#" ng-click="vote(idea.id)"
                                                                 class="btn btn-success bb-btn-voting">{{idea.votes}} <span
                    class="glyphicon glyphicon-thumbs-up"></span></a> <span
                class="bb-shadow">{{idea.title}}</span> <span
                class="label label-info">{{idea.duration}} min</span></li>
    </ul>
    <a href="#" class="btn btn-info" ng-show="!editPanelShown" ng-click="editPanelShown = true;">Dodaj nowy pomysł...</a>

    <div class="panel panel-info" ng-show="editPanelShown">
        <div class="panel-heading">
            <h3 class="panel-title">Dodawanie nowego pomysłu</h3>
        </div>

        <div class="panel-body">
            <div class="input-group">
                <span class="input-group-addon"></span>
                <input type="text" class="form-control" placeholder="Tytuł" ng-model="edited.title">
            </div>

            <div class="input-group">
                <span class="input-group-addon"></span>
                <input type="text" class="form-control" placeholder="Link" ng-model="edited.location">
            </div>

            <div class="input-group">
                <span class="input-group-addon"></span>
                <input type="text" class="form-control" placeholder="Czas trwania" ng-model="edited.duration">
                <span class="input-group-addon">min</span>
            </div>
        </div>

        <div class="panel-footer">
            <div class="btn-group">
                <button type="button" class="btn btn-success" ng-click="saveIdea(edited)">Zapisz</button>
                <button ng-click="editPanelShown = false" type="button" class="btn btn-warning">Anuluj</button>
            </div>
        </div>
    </div>
    <script>
        function IdeaListCtrl($scope, $http) {
            $scope.loadIdeas = function () {
                $http.get('list.json').success(function (data) {
                    $scope.ideas = data;
                })
            };

            $scope.vote = function (id) {
                $http.post('vote/' + id + '.json').success(function (data) {
                    $scope.loadIdeas()
                })
            };

            $scope.saveIdea = function(idea) {
                $http.post('save', idea).success(function (data) {
                    $scope.loadIdeas()
                    $scope.editPanelShown = false
                })
            };

            $scope.loadIdeas()
        }
    </script>
</div>
</body>
</html>
