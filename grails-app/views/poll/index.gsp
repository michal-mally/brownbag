<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Brown Bag</title>
    <meta name="layout" content="brownbag"/>
</head>

<body>
    <div class="container" ng-controller="PollsCtrl">
        <g:link action="create" class="btn btn-success btn-lg" ng-show="user.name">Dodaj nowe głosowanie</g:link>
        <oauth:connect provider="google" class="btn btn-danger btn-lg" ng-hide="user.name">Zaloguj się przez Google</oauth:connect>
    </div>
</body>
</html>
