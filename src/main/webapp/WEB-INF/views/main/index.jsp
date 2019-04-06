<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Index</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Added</th>
            <th>Content</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td><c:out value="${article.title}"></c:out></td>
                <td><c:out value="${article.created}"></c:out></td>
                <td><c:out value="${fn:substring(article.content, 0, 200)}..."></c:out></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br>

<table>
    <thead>
        <tr>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td><a href="/category/${category.id}">${category.name}</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>


</html>