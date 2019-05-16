<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="Model.Constant" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/17
  Time: 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<table>
    <tr>
        <td> User Id </td>
        <td> Email </td>
        <td> First name </td>
        <td> Last name </td>
        <td> Company </td>
        <td> Telephone </td>
        <td> status </td>
        <td> Type </td>
        <td> Edit </td>
    </tr>
<%
    List<User> list = (List)request.getAttribute("userList");
    Iterator<User> it = list.iterator();
    while(it.hasNext()){
        User user = it.next();
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getFirstName() %></td>
            <td><%= user.getLastName() %></td>
            <td><%= user.getCompany() %></td>
            <td><%= user.getTelephone() %></td>
            <td><%= user.getStatus() %></td>
            <td><%= user.getType() %></td>
            <td>
                <form action="/editUser/" method="get">
                    <input type="hidden" name="userId" value="<%= user.getId()%>">
                    <input type="submit" value="Edit"/>
                </form>
            </td>>
        </tr>
        <%
    }
%>
</body>
</html>
