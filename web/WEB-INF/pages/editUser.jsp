<%@ page import="Model.Constant" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/17
  Time: 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="user" class="Model.User" scope="request"></jsp:useBean>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<div>Edit User</div>
<form action="/action/editUser" method="post">
    <label> First name </label>
    <input type="hidden" id="id" name="User id" value="<jsp:getProperty name="user" property="id"/>"/>
    <input type="text" id="frname" name="User first name" value="<jsp:getProperty name="user" property="firstName"/>"/>
    <br>
    <label> Last name </label>
    <input type="text" id="laname" name="User last name" value="<jsp:getProperty name="user" property="lastName"/>"/>
    <br>
    <label>Email</label>
    <input type="email" id="email" name="User email" value="<jsp:getProperty name="user" property="email"/>"/>
    <br>
    <label> Password </label>
    <input type="password" id="psw" name="User password" value="<jsp:getProperty name="user" property="password"/>"/>
    <br>
    <label> Company </label>
    <input type="text" id="cp" name="User company" value="<jsp:getProperty name="user" property="company"/>"/>
    <br>
    <label> Telephone </label>
    <input type="number" id="tel" name="User telephone" value="<jsp:getProperty name="user" property="telephone"/>"/>
    <br>
    <%
        String admin, trainee;
        if(user.getType() == Constant.USERTYPE.ADMIN){
            admin = "Checked";
            trainee = null;
        }else{
            admin = null;
            trainee = "Checked";
        }
    %>
    <input type="radio" id="typeChoice1" name="User type" value="ADMIN" <%= admin %>>
    <label for="typeChoice1">Administrator</label>

    <input type="radio" id="typeChoice2" name="User type" value="TRAINEE"<%= trainee %>>
    <label for="typeChoice2">Trainee</label>
    </br>
    <%
        String active, inactive;
        if(user.getStatus() == Constant.STATUS.ACTIVE){
            active = "Checked";
            inactive = null;
        }else{
            active = null;
            inactive = "Checked";
        }
    %>
    <input type="radio" id="activeChoice1" name="User status" value="ACTIVE" <%= active %>>
    <label for="activeChoice1">Active</label>

    <input type="radio" id="typeChoice2" name="User status" value="INACTIVE"<%= inactive %>>
    <label for="typeChoice2">Inactive</label>

    <br>
    <input type="submit" value="Submit">
</form>
<form action="/index">
    <input type="submit" value="Return"/>
</form>
</body>
</html>
