<%@ page import="Model.Constant" %>
<%@ page import="org.json.JSONObject" %>
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
<%--<jsp:useBean id="questionnaire" class="Model.Questionnaire" scope="session"></jsp:useBean>--%>
<%
    JSONObject Json = new JSONObject(request.getAttribute("json").toString());
%>
<head>
    <title>
        <%= Json.getJSONObject("questionnaire").getString("subject") %>
        <%--<jsp:getProperty name="questionnaire" property="subject"/>--%>
    </title>
</head>
<body>
<div>
    <%= Json.getJSONObject("questionnaire").getString("subject") %>
</div>
<%
    if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
%>
<form action="/createQuestion" method="post">
    <label> Create New Question </label>
    <input type="hidden" name="questionnaireId" value="<%=Json.getJSONObject("questionnaire").getInt("id")%>"/>
    <input type="submit" value="Create">
</form>
<%
    }
%>

<div>Question List</div>

<form action="/commit" method="post">
    <table>
        <tr>
            <td>
                Questionn Id
            </td>
            <td>
                Subject
            </td>
            <td>
                Answers
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
        <%
            for (int indexQuestion = 0; indexQuestion < Json.getJSONArray("question").length(); indexQuestion++) {
                JSONObject question=Json.getJSONArray("question").getJSONObject(indexQuestion);
        %>
        <tr>
            <td>
                <%=question.getInt("id")%>
            </td>
            <td>
                <%=question.getString("text")%>
            </td>

            <td>
                <%
                    for (int indexAnswer = 0; indexAnswer < question.getJSONArray("answer").length(); indexAnswer++) {
                        JSONObject answer=question.getJSONArray("answer").getJSONObject(indexAnswer);
                %>
                    <input type="radio" id="<%=answer.getInt("id")%>" name="<%=question.getInt("id")%>"
                           value="<%=answer.getInt("id")%>">
                    <label for="<%=answer.getInt("id")%>"><%=answer.getString("text")%></label>
                <%
                    }
                %>
            </td>

            <%
                if (session.getAttribute("type") == Constant.USERTYPE.ADMIN) {
            %>
            <td>
                <%=question.getString("status")%>
            </td>
            <%
                }
            %>
            <td>
                <form action="/question" method="post">
                    <input type="hidden" name="questionnaireId"
                           value="<%=question.getInt("id")%>>"/>
                    <input type="submit" value="Modify"/>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <input type="hidden" value="<%=request.getAttribute("json").toString()%>">
    <input type="submit" value="Commit"/>
</form>
<form action="/index" method="post">
    <input type="submit" value="Return"/>
</form>
</body>
</html>
