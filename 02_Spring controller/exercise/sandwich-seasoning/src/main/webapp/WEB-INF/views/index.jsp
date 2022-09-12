<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/12/2022
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich condiments</h1>
<form action="save" method="get">
    <table>
        <tr>
            <td><input type="checkbox" name="condiments" value="Lettuce">Lettuce</td>
            <td><input type="checkbox" name="condiments" value="Tomato">Tomato</td>
            <td><input type="checkbox" name="condiments" value="Mustard">Mustard</td>
            <td><input type="checkbox" name="condiments" value="Sprouts">Sprouts</td>
        </tr>
        <tr>
            <td><input type="submit" value="save"></td>
        </tr>
    </table>
</form>
<h1>------spice list-------</h1>
<c:forEach items="${condiments}" var="spice">
    <h3>${spice}</h3>
</c:forEach>
</body>
</html>
