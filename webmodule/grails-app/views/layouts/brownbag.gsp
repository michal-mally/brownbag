<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="brownbag">
<head>
    <title>Brown Bag</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'brownbag.css')}" type="text/css">
    <r:require modules="bootstrap"/>
    <r:require modules="brownbag"/>
    <g:layoutHead/>
    <g:javascript library="application"/>
    <r:layoutResources/>
</head>

<body>
<div ng-controller="AuthCtrl">
    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#brownbag-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brown Bag</a>
            </div>

            <div class="collapse navbar-collapse" id="brownbag-navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li ng-show="user"><a href="" ng-click="logout()">{{user.name}} <span class="glyphicon glyphicon-log-out"></span></a></li>
                    <li ng-hide="user"><a href="<g:createLink controller="auth" action="login" id="google" />?redirectUri={{location.path()}}">Logowanie Google</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div ng-hide="user" class="alert alert-danger">
            Zaloguj się by korzystać ze wszystkich funkcji aplikacji.
        </div>

        <g:layoutBody/>
    </div>
    <r:layoutResources/>
</div>
</body>
</html>
