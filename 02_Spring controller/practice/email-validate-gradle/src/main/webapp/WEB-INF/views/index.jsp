<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/11/2022
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Email validate</h1>
<h3 style="color: red"> ${mess}</h3>

<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="validate">
</form>

<h3> Hi: ${email}</h3>
</body>
</html>
