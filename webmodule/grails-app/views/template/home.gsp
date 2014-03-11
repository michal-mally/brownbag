<form ng-show="user" name="poll_form" class="form-inline" role="form" novalidate ng-submit="createPoll(poll)">
    <div class="form-group">
        <label class="sr-only" for="name">Nazwa głosowania</label>
        <input type="text" class="form-control" ng-model="poll.name" id="name" placeholder="Nazwa głosowania">
    </div>
    <button type="submit" class="btn btn-success">Dodaj głosowanie</button>
</form>

<div ng-show="user" class="panel panel-primary">
    <div class="panel-heading">Ostatnia aktywność</div>
    %{--<div class="panel-body">
        <p>...</p>
    </div>--}%

    <ul class="list-group">
        <li ng-repeat="poll in userActivity.polls | orderBy:'lastTime':true | limitTo:10" class="list-group-item"><a href="#/{{poll.id}}">{{poll.id}}</a></li>
    </ul>
</div>
