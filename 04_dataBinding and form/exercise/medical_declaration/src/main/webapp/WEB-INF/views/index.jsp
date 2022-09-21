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
            <div class="col-3" style="text-align: center"><form:radiobutton path="travel" value="máy bay"
                                                                            label="Máy bay"/></div>
            <div class="col-3" style="text-align: center"><form:radiobutton path="travel" value="Tàu Thuyền"
                                                                            label="Tàu thuyền"/></div>
            <div class="col-3" style="text-align: center"><form:radiobutton path="travel" value="Ô tô"
                                                                            label="Ô tô"/></div>
            <div class="col-3" style="text-align: center"><form:radiobutton path="travel" value="khác"
                                                                            label="Khác"/></div>
        </div>
        <div class="row">
            <div class=" col-6">
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