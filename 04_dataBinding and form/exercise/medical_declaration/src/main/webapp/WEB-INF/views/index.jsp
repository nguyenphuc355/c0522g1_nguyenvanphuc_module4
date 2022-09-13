<%--<!doctype html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--    <title>Title</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
<%--    <style>--%>
<%--        input {--%>
<%--            width: 100%;--%>
<%--        }--%>

<%--        select {--%>
<%--            width: 100%;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="text-center"><h2>TỜ KHAI Y TẾ</h2></div>--%>
<%--<div class="text-center"><P>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN LIÊN LẠC KHI CẦN THIẾT ĐỂ--%>
<%--    PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</P></div>--%>
<%--<form:form modelAttribute="declaration" method="post" action="info">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Name</td>--%>
<%--            <td><form:input path="name"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>birthday</td>--%>
<%--            <td><form:input path="birthDay"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="gender">gender </form:label></td>--%>
<%--            <td><form:radiobutton path="gender" value="1" label="Male"/></td>--%>
<%--            <td><form:radiobutton path="gender" value="0" label="Female"/></td>--%>
<%--            <td><form:radiobutton path="gender" value="2" label="LGBT"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>country</td>--%>
<%--            <td><form:input path="country"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>passport</td>--%>
<%--            <td><form:input path="passport"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>travel</td>--%>
<%--            <td><form:input path="travel"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Vehicle number</td>--%>
<%--            <td><form:input path="vehicleNumber"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Seat number</td>--%>
<%--            <td><form:input path="seatNumber"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>start day</td>--%>
<%--            <td><form:input path="startDay"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>End day</td>--%>
<%--            <td><form:input path="endDay"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Status</td>--%>
<%--            <td><form:input path="status"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" value="Submit"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form:form>--%>

<%--</body>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        input {
            width: 100%;
        }

        body {
            margin: 30px;
        }
    </style>

</head>
<body>
<h1 style="text-align: center">Tờ khai y tế </h1>
<p style="text-align: center"> Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi cần
    thiết để
    phòng chống bệnh truyền nhiễm</p>
<h5 style="color: red;text-align: center">Khuyến cáo : khai báo thông tin sai là vi phạm pháp luật</h5>
<form:form modelAttribute="declaration" method="post" action="info">
    <div class="container-fluid">
        <div class="row">
            Họ tên (ghi chữ in hoa)(*)
        </div>
        <div class="row">
            <td><form:input path="name"/></td>
        </div>
        <div class="row">
            <div class="col-4">
                <div class="row">Ngày sinh</div>
                <div class="row"><form:select path="birthDay" items="${birthdayList}"/></div>
            </div>

            <div class="col-4">
                <div class="row">Giới tính</div>
                <div class="row"><form:select path="gender" items="${genderList}"/></div>
            </div>
            <div class="col-4">
                <div class="row">Quốc tịch</div>
                <div class="row"><form:select path="country" items="${countryList}"/></div>
            </div>
        </div>
        <div class="row">
            Số hộ chiếu/ số CMND hoặc giấy tờ khác (*)
        </div>
        <div class="row">
            <div class="col-12"><form:input path="passport"/></div>
        </div>
        <div class="row">
            Thông tin đi lại
        </div>
        <div class="row ">
            <div class="col-3"><form:radiobutton path="travel" value="máy bay" label="Máy bay"/></div>
            <div class="col-3"><form:radiobutton path="travel" value="Tàu Thuyền" label="Tàu thuyền"/></div>
            <div class="col-3"><form:radiobutton path="travel" value="Ô tô" label="Ô tô"/></div>
            <div class="col-3"><form:radiobutton path="travel" value="khác" label="Khác"/></div>
        </div>
        <div class="row">
            <div col-6>
                <div class="row">Số hiệu phương tiên (*)</div>
                <div class="row"><form:input path="vehicleNumber"/></div>
            </div>
            <div class="col-6">
                <div class="row">Số ghế (*)</div>
                <div class="row"><form:input path="seatNumber"/></div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="row">Ngày khởi hành (*)</div>
                <div class="row"><form:input path="startDay"/></div>
            </div>
            <div class="col-6">
                <div class="row">Ngày kết thúc (*)</div>
                <div class="row"><form:input path="endDay"/></div>
            </div>
        </div>
        <div class="col-12">
            <div class="row">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/ thành phố nào? (*)</div>
            <div class="row"><form:textarea path="status"/></div>
        </div>
        <div class="col-1">
            <div><form:button>Gửi tờ khai</form:button></div>
        </div>
    </div>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>