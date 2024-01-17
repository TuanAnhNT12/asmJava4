<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 11/30/2023
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!--Nhúng Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">KHÁCH HÀNG CHI TIẾT</h2>
<form class="row g-3 col-lg-8 mt-3" action="/khach-hang/sua?id=${kh.id}" method="post">
    <div>
        <label for="validationDefault" class="form-label">Id:</label>
        <input value="${kh.id}" name="id" type="text" class="form-control" id="validationDefault" disabled>
    </div>
    <div>
        <label for="validationDefault01" class="form-label">Mã:</label>
        <input value="${kh.ma}" name="ma" type="text" class="form-control" id="validationDefault01" required>
    </div>
    <div>
        <label for="validationDefaulta" class="form-label">Họ:</label>
        <input value="${kh.ho}" name="ho" type="text" class="form-control" id="validationDefaulta" required>
    </div>
    <div>
        <label for="validationDefault02" class="form-label">Tên đệm:</label>
        <input value="${kh.tenDem}" name="tenDem" type="text" class="form-control" id="validationDefault02" required>
    </div>
    <div>
        <label for="validationDefault10" class="form-label">Tên:</label>
        <input value="${kh.ten}" name="ten" type="text" class="form-control" id="validationDefault10" required>
    </div>
    <div>
        <label for="validationDefault13" class="form-label">Ngày sinh:</label>
        <input value="${kh.ngaySinh}" name="ngaySinh" type="date" class="form-control" id="validationDefault13" required>
    </div>
    <div>
        <label for="validationDefault04" class="form-label">Số điện thoại:</label>
        <input value="${kh.sdt}" name="sdt" type="text" class="form-control" id="validationDefault04" required>
    </div>
    <div>
        <label for="validationDefault03" class="form-label">Địa chỉ:</label>
        <input value="${kh.diaChi}" name="diaChi" type="text" class="form-control" id="validationDefault03" required>
    </div>
    <div>
        <label for="validationDefault07" class="form-label">Thành phố:</label>
        <input value="${kh.thanhPho}" name="thanhPho" type="text" class="form-control" id="validationDefault07" required>
    </div>
    <div>
        <label for="validationDefault08" class="form-label">Quốc gia:</label>
        <input value="${kh.quocGia}" name="quocGia" type="text" class="form-control" id="validationDefault08" required>
    </div>
    <div>
        <label for="validationDefault05" class="form-label">Mật khẩu:</label>
        <input value="${kh.matKhau}" name="mk" type="text" class="form-control" id="validationDefault05" required>
    </div>

    <div class="d-flex justify-content-center align-items-center">
        <button class="btn btn-warning" type="submit">Cập nhật</button>
    </div>
</form>
</body>
</html>
