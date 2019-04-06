<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit author</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

    <form:form method="post" modelAttribute="author" action="/author/edit">
        <div>First name: <form:input path="firstName"/><form:errors path="firstName"/></div><br>
        <div>Last name: <form:input path="lastName"/><form:errors path="lastName"/></div><br>
        <form:hidden path="id"/>
        <input type="submit" value="Save">
    </form:form>
</body>
</html>