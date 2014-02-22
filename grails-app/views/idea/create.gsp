<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:renderErrors bean="${idea}" as="list" />
    <g:form action="save">
        <div>
            <label>Tytuł</label><g:textField name="title" value="${idea?.title}" />
        </div>
        <div>
            <label>Link</label><g:textField name="location" value="${idea?.location}"/>
        </div>
        <div>
            <label>Czas trwania</label><g:textField name="duration" value="${idea?.duration}" />m
        </div>
        <g:submitButton name="Dodaj" />
    </g:form>
    <g:link action="index">Anuluj</g:link>
</body>
</html>
