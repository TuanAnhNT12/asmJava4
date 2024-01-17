<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 11/29/2023
  Time: 10:33 PM
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
<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">CỬA HÀNG</h2>
<div class="d-flex justify-content-end align-items-center">
    <button type="button" class="btn btn-success mt-20 mb-4" data-bs-toggle="modal" data-bs-target="#exampleModal">+ Thêm cửa hàng</button>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Nhập thông tin cửa hàng</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="row g-3" action="/cua-hang/them" method="post">
                    <div>
                        <label for="validationDefault01" class="form-label">Mã:</label>
                        <input name="ma" type="text" class="form-control" id="validationDefault01" required>
                    </div>
                    <div>
                        <label for="validationDefault02" class="form-label">Tên:</label>
                        <input name="ten" type="text" class="form-control" id="validationDefault02" required>
                    </div>
                    <div>
                        <label for="validationDefault03" class="form-label">Địa chỉ:</label>
                        <input name="dc" type="text" class="form-control" id="validationDefault03" required>
                    </div>
                    <div>
                        <label for="validationDefault04" class="form-label">Thành phố:</label>
                        <input name="tp" type="text" class="form-control" id="validationDefault04" required>
                    </div>
                    <div>
                        <label for="validationDefault05" class="form-label">Quốc gia:</label>
                        <input name="qg" type="text" class="form-control" id="validationDefault05" required>
                    </div>
                    <div class="d-flex justify-content-center align-items-center">
                        <button class="btn btn-primary" type="submit">Thêm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="card border-info mb-3" style="width: 100%;">
    <div class="card text-bg-info card-header">Danh sách cửa hàng</div>
    <div class="card-body">
        <table class="table align-middle table-bordered">
            <thead>
            <tr>
                <th scope="col" class="text-center">ID</th>
                <th scope="col" class="text-center">Mã</th>
                <th scope="col" class="text-center">Tên</th>
                <th scope="col" class="text-center">Địa chỉ</th>
                <th scope="col" class="text-center">Thành phố</th>
                <th scope="col" class="text-center">Quốc gia</th>
                <th scope="col" class="text-center"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="i" items="${lstCH}" var="ch">
                <tr>
                    <td scope="row" >${ch.id}</td>
                    <td>${ch.ma}</td>
                    <td >${ch.ten}</td>
                    <td >${ch.diaChi}</td>
                    <td >${ch.thanhPho}</td>
                    <td >${ch.quocGia}</td>
                    <td>
                        <a href="/cua-hang/chi-tiet?id=${ch.id}"><button class="btn btn-primary">Xem</button></a>
                        <a href="/cua-hang/xoa?id=${ch.id}"><button class="btn btn-danger">Xóa</button></a>
                    </td>



                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
