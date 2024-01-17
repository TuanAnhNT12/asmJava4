<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/2/2023
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Xem chi tiet</title>
    <!--Nhúng Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">DÒNG SẢN PHẨM CHI TIẾT</h2>
<form class="row g-3 col-lg-8 mt-3" action="/dongsp/sua?id=${dsp.id}" method="post">
    <div >
        <label for="validationDefault" class="form-label">ID:</label>
        <input value="${dsp.id}" name="id" type="text" class="form-control" id="validationDefault" disabled>
    </div>
    <div>
        <label for="validationDefault01" class="form-label">Mã:</label>
        <input value="${dsp.ma}" name="ma" type="text" class="form-control" id="validationDefault01" required>
    </div>
    <div>
        <label for="validationDefault02" class="form-label">Tên:</label>
        <input value="${dsp.ten}" name="ten" type="text" class="form-control" id="validationDefault02" required>
    </div>
    <div class="d-flex justify-content-center align-items-center mt-3">
        <button class="btn btn-warning" type="submit">Cập nhật</button>
    </div>
</form>
</body>
</html>
