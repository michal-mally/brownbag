<div ng-show="user" class="panel panel-primary">
    <div class="panel-heading">Ostatnia aktywność</div>
    %{--<div class="panel-body">
        <p>...</p>
    </div>--}%

    <ul class="list-group">
        <li ng-repeat="poll in userActivity.polls | orderBy:'lastTime':true | limitTo:10" class="list-group-item"><a href="#/{{poll.id}}">{{poll.id}}</a></li>
    </ul>
</div>

<a href="" ng-click="createPoll()" class="btn btn-success" ng-disabled="user == null">Dodaj głosowanie...</a>
