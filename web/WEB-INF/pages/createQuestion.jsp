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
<form action="/action/createQuestion" method="post">
    <label> Subject </label>
    <input type="text" id="subject" name="Question subject"/>
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
    <label> Which answer is correct?</label>
    <select id="Correction" name="Correction">
        <option value ="AnswerCorrection1">Answer1</option>
        <option value ="AnswerCorrection2">Answer2</option>
        <option value ="AnswerCorrection3">Answer3</option>
        <option value ="AnswerCorrection4">Answer4</option>
    </select>
    <br>
    <label>Questionnaire</label>
    <input type="text" id="questionnaireId" name="questionnaireId" value="<%= request.getParameter("questionnaireId") %>">
    <input type="submit" value="Submit">
</form>
</body>
</html>
