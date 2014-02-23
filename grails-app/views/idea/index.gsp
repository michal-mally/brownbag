<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <r:require modules="bootstrap"/>
    <r:layoutResources/>
</head>

<body style="padding-top: 8ex;">
<div class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Brown Bag</a>
        </div>
    </div>
</div>
<div class="container ">
    <ul class="list-group">
        <g:each in="${ideaList}" var="idea">
            <li class="list-group-item"><a href="#" class="btn btn-success" style="width: 4em;">${idea.votes} <span
                    class="glyphicon glyphicon-thumbs-up"></span></a> <span
                    style="text-shadow: 0 1px 3px rgba(0,0,0,.5);">${idea.title}</span> <span
                    class="label label-info">${idea.duration} min</span></li>
        </g:each>
    </ul>

    <div class="input-group">
        <span class="input-group-addon"></span>
        <input type="text" class="form-control" placeholder="Tytuł">
    </div>

    <div class="input-group">
        <span class="input-group-addon"></span>
        <input type="text" class="form-control" placeholder="Link">
    </div>

    <div class="input-group">
        <span class="input-group-addon"></span>
        <input type="text" class="form-control" placeholder="Czas trwania w minutach">
    </div>
</div>
</body>
</html>
