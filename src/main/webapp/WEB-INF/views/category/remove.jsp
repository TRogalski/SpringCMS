<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Remove category</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

Name: <c:out value="${category.name}"></c:out><br>
Description: <c:out value="${category.description}"></c:out><br>

<p>Are you sure that you want to remove the above?</p><br>
<form:form modelAttribute="category" action="/category/remove">
    <form:hidden path="id" name="id"/>
    <input type="submit" value="Remove">
</form:form>


</body>
</html>