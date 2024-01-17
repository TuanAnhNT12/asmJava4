<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 11/30/2023
  Time: 10:51 PM
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
<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">SẢN PHẨM</h2>
<div class="d-flex justify-content-end align-items-center">
    <button type="button" class="btn btn-success mt-20 mb-4" data-bs-toggle="modal" data-bs-target="#exampleModal">+ Thêm sản phẩm</button>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Nhập thông tin sản phẩm</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="row g-3" action="/san-pham/them" method="post" enctype="multipart/form-data">
                    <div>
                        <label for="validationDefault03" class="form-label">Hình ảnh:</label><br>
                        <img id="anh123" class="mb-2" src="#" style="border-radius: 10px;" height="170px"
                                 width="315px">
                        <input name="anh" type="file"  class="form-control" id="validationDefault03" onchange="xemTruocAnh(event)" required>



                    </div>
                    <div>
                        <label for="validationDefault01" class="form-label">Mã:</label>
                        <input name="ma" type="text" class="form-control" id="validationDefault01" required>
                    </div>
                    <div>
                        <label for="validationDefault02" class="form-label">Tên:</label>
                        <input name="ten" type="text" class="form-control" id="validationDefault02" required>
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
    <div class="card text-bg-info card-header">Danh sách chức vụ</div>
    <div class="card-body">
        <table class="table align-middle table-bordered">
            <thead>
            <tr>
                <th scope="col" class="text-center">Ảnh</th>
                <th scope="col" class="text-center">ID</th>
                <th scope="col" class="text-center">Mã</th>
                <th scope="col" class="text-center">Tên</th>
                <th scope="col" class="text-center"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="i" items="${lstSP}" var="sp">
                <tr>
                    <td scope="row" >
                    <c:forEach items="${doi}" var="a">
                        <c:if test="${sp.id == a.key}">
                            <img src="data:image/png;base64,${a.value}" height="50px" width="100px"/>
                        </c:if>
                    </c:forEach>
                    </td>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td >${sp.ten}</td>
                    <td>
                        <a href="/san-pham/chi-tiet?id=${sp.id}"><button class="btn btn-primary">Xem</button></a>
                        <a href="/san-pham/xoa?id=${sp.id}"><button class="btn btn-danger">Xóa</button></a>
                    </td>



                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    // Hàm JavaScript để xem trước hình ảnh được tải lên
    function xemTruocAnh(event) {
        const file = event.target.files[0]; // Lấy file đã tải lên
        const reader = new FileReader();

        reader.onload = function() {
            const imgElement = document.getElementById('anh123');
            imgElement.src = reader.result; // Đặt nguồn của hình ảnh là file đã tải lên
        }

        if (file) {
            reader.readAsDataURL(file); // Đọc file dưới dạng URL dữ liệu
        }
    }
</script>
</body>

</html>
