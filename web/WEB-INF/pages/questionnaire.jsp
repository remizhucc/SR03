<%@ page import="Model.Constant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuchenyan
  Date: 2019/5/2
  Time: 下午12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="questionnaire" class = "Model.Questionnaire" scope="session" ></jsp:useBean>
<head>
    <title>
        <jsp:getProperty name="questionnaire" property="subject"/>
    </title>
</head>
<body>

<div>
    <jsp:getProperty name="questionnaire" property="subject"/>
</div>
<%
    if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
%>
<form action="/createquestion" method="post">
    <label> Create New Question </label>
    <input type="submit" value="Create">
</form>
<%
    }
%>

<div>Questionn List</div>

<table>

    <tr>
        <td>
            Questionn Id
        </td>
        <td>
            Subject
        </td>
        <%
            if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
        %>
        <td>
            Status
        </td>
        <%
            }
        %>
    </tr>
    <c:forEach var="question" items="${questionList}">

        <tr>
            <td>
                <c:out value="${question.getId()}"/>
            </td>
            <td>
                <c:out value="${question.getText()}"/>
            </td>
            <%
                if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
            %>
            <td>
                <c:out value="${question.getStatus()}"/>
            </td>
            <%
                }
            %>
            <td>
                <form action="/question" method="post">
                    <input type="hidden" name="resultId" value="${questionnaire.getId()}"/>
                    <input type="submit" value="Enter"/>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>

<form action="/index">
    <input type="submit" value="Return"/>
</form>

</body>
</html>
