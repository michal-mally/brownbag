<form ng-show="user" name="poll_form" class="form-inline" role="form" novalidate ng-submit="createPoll(poll)">
    <div class="form-group" ng-class="">
        <label class="sr-only" for="name">Nazwa głosowania</label>
        <input type="text" class="form-control" ng-model="poll.name" name="name" id="name" placeholder="Nazwa głosowania" ng-minlength="6" maxlength="100" required>
    </div>
    <button type="submit" class="btn btn-success" ng-disabled="poll_form.$invalid">Dodaj głosowanie</button>
    <span ng-show="poll_form.name.$error.minlength" class="text-danger">Nazwa musi mieć co najmniej 6 znaków</span>
</form>

<div ng-show="user" class="panel panel-primary">
    %{--<div class="panel-body">
        <p>...</p>
    </div>--}%

    <table class="table">
        <thead class="bg-primary">
        <tr>
            <th style="width: 100%">Ostatnie głosowania</th>
            <th><span class="glyphicon glyphicon-plus"></span></th>
            <th><span class="glyphicon glyphicon-tags"></span></th>
            <th><span class="glyphicon glyphicon-thumbs-up"></span></th>
            <th><span class="glyphicon glyphicon-eye-open"></span></th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="poll in userActivity.polls | orderBy:'lastTime':true | limitTo:10">
            <td><a href="#/{{poll.id}}">{{poll.name}}</a></td>
            <td><span ng-show="hasType(poll, 'create')" class="glyphicon glyphicon-ok"></span></td>
            <td><span ng-show="hasType(poll, 'createIdea')" class="glyphicon glyphicon-ok"></span></td>
            <td><span ng-show="hasType(poll, 'voteIdea')" class="glyphicon glyphicon-ok"></span></td>
            <td><span ng-show="hasType(poll, 'show')" class="glyphicon glyphicon-ok"></span></td>
        </tr>
        </tbody>
    </table>
</div>
