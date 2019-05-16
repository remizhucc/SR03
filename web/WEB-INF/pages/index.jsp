<%@ page import="Model.Constant" %><%--
  Created by IntelliJ IDEA.
  User: zhuchenyan
  Date: 2019/5/2
  Time: 下午1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

<form action="/questionnaireList" method="post">
    <input type="submit" value="Questionnaire list"/>
</form>
<form action="/resultList" method="post">
    <input type="submit" value="Result list"/>
</form>

<%
    if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
%>

<form action="/createUser" method="get">
    <input type="submit" value="Create user"/>
</form>
<form action="/User/all" method="get">
    <input type="submit" value="User list"/>
</form>

<%
    }
%>

</body>
</html>
