<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/13/2022
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
<body>
<h2 style="color: aqua">${message}</h2>
<table class="table table-striped">
    <tr>
        <td>Language</td>
        <td>Page size</td>
        <td>Spam filter</td>
        <td>Signature</td>
        <td>Update</td>
    </tr>
    <c:forEach var="emailList" items="${listEmail}">
        <tr>
            <td>${emailList.languages}</td>
            <td>${emailList.pageSize}</td>
            <td>${emailList.spamFilter}</td>
            <td>${emailList.signature}</td>
            <td><a href="/update?id=${emailList.id}">update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</html>
