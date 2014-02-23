<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app>
<head>
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'brownbag.css')}" type="text/css">
    <r:require modules="bootstrap"/>
    <r:require modules="angular"/>
    <g:layoutHead/>
    <g:javascript library="application"/>
    <r:layoutResources/>
</head>

<body>
<div class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Brown Bag</a>
        </div>
    </div>
</div>
<g:layoutBody/>
<r:layoutResources/>
</body>
</html>
