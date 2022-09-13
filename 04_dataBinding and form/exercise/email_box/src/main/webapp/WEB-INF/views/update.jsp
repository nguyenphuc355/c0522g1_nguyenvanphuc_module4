<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/13/2022
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="email" type="email_box"--%>
<form:form action="save" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Language:</td>
            <td>Show <form:select path="languages" items="${languages}"/>emails per page</td>
        </tr>
        <tr>
            <td>Language:</td>
            <td><form:select path="pageSize" items="${pageSize}"/></td>
        </tr>
        <tr>
            <td>Spam filter:</td>
            <td><form:checkbox path="spamFilter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td>
                <button type="submit">save</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
