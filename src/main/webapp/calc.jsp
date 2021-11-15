<%--
  Created by IntelliJ IDEA.
  User: Николя
  Date: 15.11.2021
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calc" method="post">
    <input name="num1" type="text" placeholder="number1">
    <input name="action" type="text" placeholder="operation">
    <input name="num2" type="text" placeholder="number2">
    <button>Calculate</button>
</form>
<form action="/logout" method="get">
    <button>logout</button>
</form>
<form action="/operationHistory" method="get">
    <button>operation history</button>
</form>
<p>${requestScope.message}${requestScope.result}</p>
</body>
</html>
