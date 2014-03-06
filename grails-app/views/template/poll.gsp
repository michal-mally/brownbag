<div class="alert alert-{{messageType}}" ng-show="message">{{message}}</div>
<ul class="list-group">
    <div class="alert alert-info"
         ng-show="ideas.length == 0">Nic tu jeszcze nie ma - dodaj śmiało swoje pomysły!</div>
    <li ng-repeat="idea in ideas | orderBy:'votes.length':true | limitTo: ideasShown" class="list-group-item"><a
            href="" ng-click="voteIdea(idea.id)"
            ng-show="!expanded"
            class="btn btn-success bb-btn-voting"
            ng-disabled="hasVoted(idea)">{{idea.votes.length}} <span
                class="glyphicon glyphicon-thumbs-up"></span></a> <span
            class="bb-shadow">{{idea.title}}</span> <span
            class="label label-info" ng-show="!expanded">{{idea.duration}} min</span><a href=""
                                                                                        class="btn btn-link"
                                                                                        ng-click="expanded = !expanded">...</a>

        <div ng-show="expanded">Link: <a href="{{idea.location}}">{{idea.location}}</a></div></li>
</ul>

<div>
    <div class="alert alert-warning"
         ng-show="ideasShown < ideas.length">Pokazywanie {{ideasShown}} z {{ideas.length}} elementów</div>
    <a href="" class="btn btn-success" ng-click="addIdea()">Dodaj nowy pomysł...</a>

    <a href="" class="btn btn-info" ng-click="showMore()" ng-disabled="ideasShown >= ideas.length">Pokaż więcej</a>
</div>
