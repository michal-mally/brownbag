<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:link action="create">Dodaj nową ideę</g:link>
    <table>
        <g:each in="${ideaList}" var="idea">
            <tbody>
                <tr>
                    <td><a href="<g:createLink action="show" id="${idea.id}"/>">${idea.title}</a></td>
                    <td>${idea.location}</td>
                    <td>${idea.duration}</td>
                </tr>
            </tbody>
        </g:each>
    </table>
</body>
</html>
