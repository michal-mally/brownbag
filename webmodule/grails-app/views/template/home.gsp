<form ng-show="user" name="poll_form" class="form-inline" role="form" novalidate ng-submit="createPoll(poll)">
    <div class="form-group" ng-class="">
        <label class="sr-only" for="name">Nazwa głosowania</label>
        <input type="text" class="form-control" ng-model="poll.name" name="name" id="name" placeholder="Nazwa głosowania" ng-minlength="6" maxlength="100" required>
    </div>
    <button type="submit" class="btn btn-success" ng-disabled="poll_form.$invalid">Dodaj głosowanie</button>
    <span ng-show="poll_form.name.$error.minlength" class="text-danger">Nazwa musi mieć co najmniej 6 znaków</span>
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
