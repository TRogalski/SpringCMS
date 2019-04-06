<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit category</title>
</head>
<body>

<%@ include file="/WEB-INF/views/main/nav-bar.html" %>

    <form:form method="post" modelAttribute="category" action="/category/edit">
        Name: <form:input path="name"/><br>
        Description: <form:input path="description"/><br>
        <form:hidden path="id"/>
        <input type="submit" value="Save">
    </form:form>
</body>
</html>