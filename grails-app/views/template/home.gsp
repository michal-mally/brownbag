<a href="#" ng-click="createPoll()" class="btn btn-success btn-lg" ng-show="user.name">Dodaj nowe głosowanie</a>
<oauth:connect provider="google" class="btn btn-danger btn-lg"
               ng-hide="user.name">Zaloguj się przez Google</oauth:connect>
