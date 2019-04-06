<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Category list</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><c:out value="${category.name}"></c:out></td>
            <td><c:out value="${category.description}"></c:out></td>
            <td><a href="/category/edit/${category.id}">Edit</a></td>
            <td><a href="/category/remove/${category.id}">Remove</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</html>