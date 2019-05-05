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
<head>
    <title>Questionnaire list</title>
</head>
<body>
<div>Questionnaire List</div>

<%
    if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
%>
<form action="/createquestionnaire" method="post">
    <label> Create Questionnaire </label>
    <input type="submit" value="Create">
</form>
<%
    }
%>


<table>

    <tr>
        <td>
            Questionnaire Id
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
    <c:forEach var="questionnaire" items="${questionnaireList}">

        <tr>
            <td>
                <c:out value="${questionnaire.getId()}"/>
            </td>
            <td>
                <c:out value="${questionnaire.getSubject()}"/>
            </td>
            <%
                if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
            %>
            <td>
                <c:out value="${questionnaire.getStatus()}"/>
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
