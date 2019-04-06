<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Author list</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

<table>
    <thead>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td><c:out value="${author.firstName}"></c:out></td>
            <td><c:out value="${author.lastName}"></c:out></td>
            <td><a href="/author/edit/${author.id}">Edit</a></td>
            <td><a href="/author/remove/${author.id}">Remove</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</html>