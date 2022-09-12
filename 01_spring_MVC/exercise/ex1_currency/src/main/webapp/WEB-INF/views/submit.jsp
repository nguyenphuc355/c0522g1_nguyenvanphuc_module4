<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/9/2022
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/usd">
    <table>
        <tr>
            <td>Rate:</td>
            <td><input type="text" value="230000" name="rate"></td>
        </tr>
        <tr>
            <td>USD:</td>
            <td><input type="number" name="money" placeholder="0"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" id="submit" value="Converter"></td>
        </tr>
        <tr>
            <td>Result:</td>
            <td><input placeholder="VND" value="${result}"></td>
        </tr>
    </table>
</form>
</body>
</html>
