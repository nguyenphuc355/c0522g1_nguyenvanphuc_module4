<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/12/2022
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<fieldset>
    <legend><h1>Calculator</h1></legend>
    <form action="calculate" method="get">
        <td><input type="text" name="number1" value="${number1}"></td>
        <td><input type="text" name="number2" value="${number2}"></td>
        <br>
        <p>
            <button style="background-color: aquamarine" type="submit" name="calculation" value="Addition"> Addition(+)</button>
            <button style="background-color: aquamarine" type="submit" name="calculation" value="Subtraction">Subtraction(-)</button>
            <button style="background-color: aquamarine" type="submit" name="calculation" value="Multiplication">Multiplication(*)</button>
            <button style="background-color: aquamarine" type="submit" name="calculation" value="Division">Division(/)</button>
        </p>

        <h2>Result: ${result}</h2>
    </form>
</fieldset>
</body>
</html>
