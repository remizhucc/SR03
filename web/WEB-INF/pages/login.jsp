<%--
  Created by IntelliJ IDEA.
  User: zhuchenyan
  Date: 2019/3/22
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div>Login</div>
<form action="/action/login" method="post">
    <label>Email</label>
    <input type="email" id="email" name="User email"/>
    <br>
    <label> Password </label>
    <input type="password" id="psw" name="User password"/>
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>