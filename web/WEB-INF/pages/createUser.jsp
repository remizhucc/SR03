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
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div>Create User</div>
<form action="/action/createuser" method="post">
    <label> First name </label>
    <input type="text" id="frname" name="User first name"/>
    <br>
    <label> Last name </label>
    <input type="text" id="laname" name="User last name"/>
    <br>
    <label>Email</label>
    <input type="email" id="email" name="User email"/>
    <br>
    <label> Password </label>
    <input type="password" id="psw" name="User password"/>
    <br>
    <label> Company </label>
    <input type="text" id="cp" name="User company"/>
    <br>
    <label> Telephone </label>
    <input type="number" id="tel" name="User telephone"/>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>