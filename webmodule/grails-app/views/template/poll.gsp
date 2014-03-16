<h1 class="bb-shadow text-center">{{poll.name}}</h1>

<div class="alert alert-info" ng-show="poll.ideas.length == 0">Nic tu jeszcze nie ma - dodaj śmiało swoje pomysły!</div>
<ul class="list-group">
    <li ng-repeat="idea in poll.ideas | orderBy:['-votes.length', '+lastVoteTime'] | limitTo: ideasShown"
        class="list-group-item">
        <a
                href="" ng-click="voteIdea(idea.id)"
                class="btn btn-{{frozen ? 'default' : 'success'}} bb-btn-voting"
                ng-disabled="frozen || user == null || hasVoted(idea)">{{idea.votes.length}} <span
                class="glyphicon glyphicon-thumbs-up"></span></a>
        <span
                class="bb-shadow">{{idea.title}}</span> <span
            class="label label-info" ng-show="!expanded">{{idea.duration}} min</span>

        <a href="" class="btn btn-link pull-right" ng-click="expanded = !expanded">
            <span ng-hide="expanded" class="glyphicon glyphicon glyphicon-chevron-right"></span>
            <span ng-show="expanded" class="glyphicon glyphicon glyphicon-chevron-down"></span>
        </a>

        <div class="well well-sm" style="margin-top: 1ex;" ng-show="expanded">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Lokalizacja</label>

                    <div class="col-sm-10">
                        <p class="form-control-static"><a href="{{idea.location}}">{{idea.location}}</a></p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Czas trwania</label>

                    <div class="col-sm-10">
                        <p class="form-control-static"><span class="label label-info">{{idea.duration}} minut</span>
                        </p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Oddane głosy</label>

                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <span ng-repeat="vote in idea.votes | filter:me" class="label label-success">Ty</span>
                            <span ng-repeat="vote in idea.votes | limitTo:votesShown | filter:notMe" class="label label-info" style="margin-left: 0.25em;">{{vote.name}}</span>
                            <span ng-show="idea.votes.length > votesShown">i {{idea.votes.length - votesShown}} innych</span>
                        </p>
                    </div>
                </div>

            </form>
        </div>

    </li>

</ul>

<div>
    <div class="alert alert-warning"
         ng-show="ideasShown < poll.ideas.length">Pokazywanie {{ideasShown}} z {{poll.ideas.length}} elementów</div>
    <a href="" class="btn btn-success" ng-click="createIdea()" ng-disabled="user == null">Dodaj pomysł...</a>

    <a href="" class="btn btn-info" ng-click="showMore()" ng-disabled="ideasShown >= poll.ideas.length">Pokaż więcej</a>
</div>
