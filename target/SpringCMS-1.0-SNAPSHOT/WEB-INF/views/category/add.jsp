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
    Name: <form:input path="name"/><br>
    Description: <form:input path="description"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>