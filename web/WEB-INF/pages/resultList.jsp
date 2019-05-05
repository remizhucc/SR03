<%@ page import="java.text.SimpleDateFormat" %>
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
    <title>Result list</title>
</head>
<body>
<table>

    <tr>
        <td>
            Result Id
        </td>
        <td>
            Trainee
        </td>
        <td>
            Date creation
        </td>
        <td>
            Score
        </td>
    </tr>
    <c:forEach var="result" items="${resultList}">
        <% %>
        <tr>
            <td>
                <c:out value="${result.getId()}"/>
            </td>
            <td>
                <c:out value="${result.getTrainee()}"/>
            </td>
            <td>
                <c:out value="${result.getDateCreation()}"/>
            </td>
            <td>
                <c:out value="${result.getScore()}"/>
            </td>
            <td>
                <form action="/resultDetail" method="post">
                    <input type="hidden" name="resultId" value="${result.getId()}"/>
                    <input type="submit" value="Detail"/>
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
