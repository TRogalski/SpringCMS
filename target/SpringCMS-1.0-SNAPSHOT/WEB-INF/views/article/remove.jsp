<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Remove article</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

Title: <c:out value="${article.title}"></c:out><br>
Author: <c:out value="${article.author.firstName} ${article.author.lastName}"></c:out><br>
Categories: <c:out value="${article.categories}"></c:out><br>
Content: <c:out value="${article.content}"></c:out><br>

<p>Are you sure that you want to remove the above?</p><br>
<form:form modelAttribute="article" action="/article/remove">
    <form:hidden path="id" name="id"/>
    <input type="submit" value="Remove">
</form:form>


</body>
</html>