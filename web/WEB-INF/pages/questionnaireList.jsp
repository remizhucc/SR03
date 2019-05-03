<%--
  Created by IntelliJ IDEA.
  User: zhuchenyan
  Date: 2019/5/2
  Time: 下午12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>Questionnaire List</div>
<div>this is a list</div>

<form action="/createquestionnaire" method="post">
    <label> Create Questionnaire </label>
    <input type="text" id="subject" name="Questionnaire subject"/>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
