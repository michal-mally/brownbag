<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Brown Bag</title>
    <meta name="layout" content="brownbag"/>
</head>

<body>
<div class="container" ng-controller="IdeaListCtrl">
    <div class="alert alert-{{messageType}}" ng-show="message">{{message}}</div>
    <ul class="list-group" ng-show="!editPanelShown">
        <li ng-repeat="idea in ideas | limitTo: ideasShown" class="list-group-item"><a href="#" ng-click="vote(idea.id)" ng-show="!expanded"
                                                                 class="btn btn-success bb-btn-voting">{{idea.votes}} <span
                    class="glyphicon glyphicon-thumbs-up"></span></a> <span
                class="bb-shadow">{{idea.title}}</span> <span
                class="label label-info" ng-show="!expanded">{{idea.duration}} min</span><a href="#" class="btn btn-link" ng-click="expanded = !expanded">...</a>
        <div ng-show="expanded">Link: <a href="{{idea.location}}">{{idea.location}}</a></div></li>
    </ul>
    <div ng-show="!editPanelShown">
        <div class="alert alert-warning" ng-show="ideasShown < ideas.length">Pokazywanie {{ideasShown}} z {{ideas.length}} elementów</div>
        <a href="#" class="btn btn-success" ng-click="editPanelShown = true;">Dodaj nowy pomysł...</a>
        <div class="btn-group">
            <button type="button" class="btn btn-info" ng-click="showLess()">Pokaż mniej</button>
            <button type="button" class="btn btn-info" ng-click="showMore()">Pokaż więcej</button>
        </div>
    </div>

    <div class="panel panel-info" ng-show="editPanelShown">
        <div class="panel-heading">
            <h3 class="panel-title">Dodawanie nowego pomysłu</h3>
        </div>

        <form name="idea_form" novalidate ng-submit="saveIdea(edited)">
            <div class="panel-body">

                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="text" name="title" class="form-control" placeholder="Tytuł" ng-model="edited.title" ng-minlength="6" maxlength="255" required>
                </div>
                <small class="error" ng-show="idea_form.title.$error.minlength">Tytuł musi mieć długość przynajmniej 6 znaków</small>

                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="url" name="location" class="form-control" placeholder="Link" ng-model="edited.location" required>
                </div>
                <small class="error" ng-show="idea_form.location.$error.url">Link musi być poprawnym adresem internetowym</small>

                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="number" name="duration" class="form-control" placeholder="Czas trwania" ng-model="edited.duration"
                           min="1" max="180" required>
                    <span class="input-group-addon">min</span>
                </div>
                <small class="error" ng-show="idea_form.duration.$error.min || idea_form.duration.$error.max">Czas trwania musi być liczbą pomiędzy 1 a 180</small>
            </div>

            <div class="panel-footer">
                <div class="btn-group">
                    <button type="submit" class="btn btn-success" ng-disabled="!idea_form.$valid">Zapisz</button>
                    <button ng-click="editPanelShown = false" type="button" class="btn btn-danger">Anuluj</button>
                </div>
            </div>
        </form>
    </div>
    <script>
        function IdeaListCtrl($scope, $http) {
            $scope.ideasShown = 5;

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
                    $scope.loadIdeas();
                    $scope.editPanelShown = false;
                    $scope.message = "Dodano nowy pomysł";
                    $scope.messageType = "success"
                })
            };

            $scope.showMore = function() {
                if ($scope.ideasShown <= $scope.ideas.length) {
                    $scope.ideasShown += 5;
                }
            };

            $scope.showLess = function() {
                $scope.ideasShown = Math.max($scope.ideasShown - 5, 5)
            };

            $scope.loadIdeas()
        }
    </script>
</div>
</body>
</html>
