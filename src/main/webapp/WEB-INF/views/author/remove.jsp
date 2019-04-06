<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Remove author</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

First name: <c:out value="${author.firstName}"></c:out><br>
Last name: <c:out value="${author.lastName}"></c:out><br>

<p>Are you sure that you want to remove the above?</p><br>
<form:form modelAttribute="author" action="/author/remove">
    <form:hidden path="id" name="id"/>
    <input type="submit" value="Remove">
</form:form>


</body>
</html>