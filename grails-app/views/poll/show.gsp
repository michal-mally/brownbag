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
        <div class="alert alert-info"
             ng-show="ideas.length == 0">Nic tu jeszcze nie ma - dodaj śmiało swoje pomysły!</div>
        <li ng-repeat="idea in ideas | orderBy:'votes.length':true | limitTo: ideasShown" class="list-group-item"><a href="#" ng-click="voteIdea(idea.id)"
                                                                                       ng-show="!expanded"
                                                                                       class="btn btn-success bb-btn-voting"
                                                                                       ng-disabled="hasVoted(idea)">{{idea.votes.length}} <span
                    class="glyphicon glyphicon-thumbs-up"></span></a> <span
                class="bb-shadow">{{idea.title}}</span> <span
                class="label label-info" ng-show="!expanded">{{idea.duration}} min</span><a href="#"
                                                                                            class="btn btn-link"
                                                                                            ng-click="expanded = !expanded">...</a>

            <div ng-show="expanded">Link: <a href="{{idea.location}}">{{idea.location}}</a></div></li>
    </ul>

    <div ng-show="!editPanelShown">
        <div class="alert alert-warning"
             ng-show="ideasShown < ideas.length">Pokazywanie {{ideasShown}} z {{ideas.length}} elementów</div>
        <a href="#" class="btn btn-success" ng-click="editPanelShown = true;">Dodaj nowy pomysł...</a>

        <a href="#" class="btn btn-info" ng-click="showMore()" ng-disabled="ideasShown >= ideas.length">Pokaż więcej</a>
    </div>

    <div class="panel panel-info" ng-show="editPanelShown">
        <div class="panel-heading">
            <h3 class="panel-title">Dodawanie nowego pomysłu</h3>
        </div>

        <form name="idea_form" novalidate ng-submit="addIdea(edited)">
            <div class="panel-body">

                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="text" name="title" class="form-control" placeholder="Tytuł" ng-model="edited.title"
                           ng-minlength="6" maxlength="255" required>
                </div>
                <small class="error"
                       ng-show="idea_form.title.$error.minlength">Tytuł musi mieć długość przynajmniej 6 znaków</small>

                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="url" name="location" class="form-control" placeholder="Link" ng-model="edited.location"
                           required>
                </div>
                <small class="error"
                       ng-show="idea_form.location.$error.url">Link musi być poprawnym adresem internetowym</small>

                <div class="input-group">
                    <span class="input-group-addon"></span>
                    <input type="number" name="duration" class="form-control" placeholder="Czas trwania"
                           ng-model="edited.duration"
                           min="1" max="180" required>
                    <span class="input-group-addon">min</span>
                </div>
                <small class="error"
                       ng-show="idea_form.duration.$error.min || idea_form.duration.$error.max">Czas trwania musi być liczbą pomiędzy 1 a 180</small>
            </div>

            <div class="panel-footer">
                <div class="btn-group">
                    <button type="submit" class="btn btn-success" ng-disabled="!idea_form.$valid">Zapisz</button>
                    <button ng-click="editPanelShown = false" type="button" class="btn btn-danger">Anuluj</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
