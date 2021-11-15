<%--
  Created by IntelliJ IDEA.
  User: Николя
  Date: 12.11.2021
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<%--<a href="/registration">Registration</a>--%>
<%--<a href="/authorization">Authorization</a>--%>
<%--<a href="/calc">Calculator</a>--%>
<%--<a href="/logout">Logout</a>--%>
<c:if test="${sessionScope.user == null}">
    <p>Hello guest</p>
    <a href="/registration">Registration</a>
    <a href="/authorization">Authorization</a>
</c:if>

<c:if test="${sessionScope.user != null}">
    <p>Hello ${sessionScope.user.username}</p>
    <a href="/calc">Calculator</a>
    <a href="/logout">Logout</a>
</c:if>
</body>
</html>
