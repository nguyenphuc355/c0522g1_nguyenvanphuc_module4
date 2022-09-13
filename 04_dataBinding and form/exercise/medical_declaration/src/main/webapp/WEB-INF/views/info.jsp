<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/13/2022
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
    <style>
        table{
            width: 100px;
        }
    </style>
</head>
<body>
<a href="/">back to form</a>
<table class="table">
    <tr>
        <td>Name:</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>birthDay:</td>
        <td>${birthDay}</td>
    </tr>
    <tr>
        <td>gender:</td>
        <td>${gender}</td>
    </tr>
    <tr>
        <td>country:</td>
        <td>${country}</td>
    </tr>
    <tr>
        <td>passport:</td>
        <td>${passport}</td>
    </tr>
    <tr>
        <td>travel:</td>
        <td>${travel}</td>
    </tr>
    <tr>
        <td>vehicleNumber:</td>
        <td>${vehicleNumber}</td>
    </tr>
    <tr>
        <td>seatNumber:</td>
        <td>${seatNumber}</td>
    </tr>
    <tr>
        <td>startDay:</td>
        <td>${startDay}</td>
    </tr>
    <tr>
        <td>endDay:</td>
        <td>${endDay}</td>
    </tr>
    <tr>
        <td>status:</td>
        <td>${status}</td>
    </tr>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
