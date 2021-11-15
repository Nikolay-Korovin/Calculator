<%--
  Created by IntelliJ IDEA.
  User: Николя
  Date: 15.11.2021
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OperationList</title>
</head>
<body>
<p>operations</p>
<c:forEach items="${requestScope.operationList}" var="operationList">
    <c:out value="${operationList.num1}${operationList.action}${operationList.num2}=${operationList.result}"/>
</c:forEach>
</body>
</html>