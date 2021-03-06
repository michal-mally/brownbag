brownbag.config(function ($routeProvider) {
    $routeProvider.when('/', {
            controller: 'PollListCtrl',
            templateUrl: 'template/show/home'
        }
    ).when('/:pollId', {
            controller: 'PollCtrl',
            templateUrl: 'template/show/poll'
        }
    ).when('/:pollId/idea/create', {
            controller: 'IdeaCtrl',
            templateUrl: 'template/show/ideaCreate'
        });
});
