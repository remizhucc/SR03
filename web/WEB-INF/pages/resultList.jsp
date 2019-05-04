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
    <c:forEach var="result" items="${resultList}">
        <tr>
            <td>
                <c:out value="${result.getId()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
