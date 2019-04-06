<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit draft</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

<form:form method="post" modelAttribute="article" action="/draft/edit">
    <div>Title: <form:input type="TEXT" path="title"/><form:errors path="title"/></div><br>
    <div>Content: <form:input type="TEXT" path="content"/><form:errors path="content"/></div><br>
    <form:hidden path="draft" value="${article.draft}"/>
    <form:hidden path="id" value="${article.id}"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>