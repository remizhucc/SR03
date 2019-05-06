<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuchenyan
  Date: 2019/5/2
  Time: 下午12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<div><c:out value="${questionnaire.getSubject()}"/></div>
<table>

    <tr>
        <td>
            Questionn Id
        </td>
        <td>
            Subject
        </td>
    </tr>
    <c:forEach var="question" items="${questionList}">

        <tr>
            <td>
                <c:out value="${question.getId()}"/>
            </td>
            <td>
                <c:out value="${question.getText()}"/>
            </td>
        </tr>
        <tr>
            <input type="radio" id="'${question.getId()}'+'1'" name="${question().getId()}" checked="${question().getAnswers().get(0).getChecked()}">
            <label for="'${question.getId()}'+'1'" color="${question().getAnswers().get(0).getChecked()&&!question().getAnswers().get(0).getCorrection()}">${question().getAnswers().get(0).getText() }</label>
        </tr>

        <tr>
            <input type="radio" id="'${question.getId()}'+'2'" name="${question().getId()}" checked="${question().getAnswers().get(1).getChecked()}">
            <label for="'${question.getId()}'+'2'" color="${question().getAnswers().get(0).getChecked()&&!question().getAnswers().get(1).getCorrection()}">${question().getAnswers().get(1).getText()}</label>
        </tr>

        <tr>
            <input type="radio" id="'${question.getId()}'+'3'" name="${question().getId()}" checked="${question().getAnswers().get(2).getChecked()}">
            <label for="'${question.getId()}'+'3'" color="${question().getAnswers().get(0).getChecked()&&!question().getAnswers().get(2).getCorrection()}">${question().getAnswers().get(2).getText()}</label>
        </tr>

        <tr>
            <input type="radio" id="'${question.getId()}'+'4'" name="${question().getId()}" checked="${question().getAnswers().get(3).getChecked()}">
            <label for="'${question.getId()}'+'4'" color="${question().getAnswers().get(0).getChecked()&&!question().getAnswers().get(3).getCorrection()}">${question().getAnswers().get(3).getText()}</label>
        </tr>
    </c:forEach>
</table>

<form action="/resultList" method="post">
    <input type="submit" value="Result list"/>
</form>


</body>
</html>
