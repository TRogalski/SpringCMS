<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add category</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

<form:form method="post" modelAttribute="category" action="/category/add">
    <div>Name: <form:input path="name"/><form:errors path="name"/></div><br>
    <div>Description: <form:input path="description"/><form:errors path="description"/></div>><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>