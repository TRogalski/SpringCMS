<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit article</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

<form:form method="post" modelAttribute="article" action="/article/edit">
    Title: <form:input type="TEXT" path="title"/><br>
    Autor: <form:select path="author" items="${authors}" itemLabel="lastName" itemValue="id"/><br>
    Categories: <form:select multiple="true" items="${categories}" itemLabel="name" itemValue="id" path="categories"/><br>
    Content: <form:input type="TEXT" path="content"/><br>
    <form:hidden path="id" value="${article.id}"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>