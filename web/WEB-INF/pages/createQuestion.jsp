<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/3
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>Create Question</div>
<form action="/action/createquestion" method="post">
    <label> Subject </label>
    <input type="text" id="subject" name="Questionn subject"/>
    <br>
    <label> Answer1 </label>
    <input type="text" id="Answer1" name="Answer1"/>
    <br>
    <label> Answer2 </label>
    <input type="text" id="Answer2" name="Answer2"/>
    <br>
    <label> Answer3 </label>
    <input type="text" id="Answer3" name="Answer3"/>
    <br>
    <label> Answer4 </label>
    <input type="text" id="Answer4" name="Answer4"/>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
