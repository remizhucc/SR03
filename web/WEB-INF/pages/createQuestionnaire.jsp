<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/27
  Time: 5:24
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
<div>Create Question</div>
<form action="/createQuestion" method="post">
    <input type="submit" value="CreateQuestion" />
</form>
<form action="/action/createquestionnaire" method="post">
    <label> Subject Of Questionnaire </label>
    <input type="text" id="subject" name="Questionnaire subject"/>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>