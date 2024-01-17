<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 11/30/2023
  Time: 9:25 AM
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
<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">QUẢN LÝ NHÂN VIÊN</h2>

<div class="d-flex justify-content-end align-items-center">
    <button type="button" class="btn btn-success mt-20 mb-4" data-bs-toggle="modal" data-bs-target="#exampleModal">+ Thêm nhân viên</button>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Nhập thông tin nhân viên</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="row g-3" action="/nhan-vien/them" method="post">
                    <div>
                        <label for="validationDefault01" class="form-label">Mã:</label>
                        <input name="ma" type="text" class="form-control" id="validationDefault01" required>
                    </div>
                    <div>
                        <label for="validationDefaulta" class="form-label">Họ:</label>
                        <input name="ho" type="text" class="form-control" id="validationDefaulta" required>
                    </div>
                    <div>
                        <label for="validationDefault02" class="form-label">Tên đệm:</label>
                        <input name="tenDem" type="text" class="form-control" id="validationDefault02" required>
                    </div>
                    <div>
                        <label for="validationDefault10" class="form-label">Tên:</label>
                        <input name="ten" type="text" class="form-control" id="validationDefault10" required>
                    </div>
                    <div>
                        <label class="form-label">Giới tính:</label>
                        <div class="d-flex justify-content-start">
                            <div class="form-check">
                                <input name="gioiTinh" value="Nam" class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    Nam
                                </label>
                            </div>
                            <div class="form-check">
                                <input name="gioiTinh" value="Nữ" class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Nữ
                                </label>
                            </div>
                        </div>
                    </div>
                    <div>
                        <label for="validationDefault13" class="form-label">Ngày sinh:</label>
                        <input name="ngaySinh" type="date" class="form-control" id="validationDefault13" required>
                    </div>

                    <div>
                        <label for="validationDefault03" class="form-label">Địa chỉ:</label>
                        <input name="diaChi" type="text" class="form-control" id="validationDefault03" required>
                    </div>
                    <div>
                        <label for="validationDefault04" class="form-label">Số điện thoại:</label>
                        <input name="sdt" type="text" class="form-control" id="validationDefault04" required>
                    </div>
                    <div>
                        <label for="validationDefault05" class="form-label">Mật khẩu:</label>
                        <input name="mk" type="text" class="form-control" id="validationDefault05" required>
                    </div>

                    <div>
                        <label class="form-label">Cửa hàng:</label>
                        <select name="cuaHang" class="form-select" aria-label="Default select example">
                            <c:forEach varStatus="i" items="${lstCH}" var="ch">
                                <option value="${ch.id}">${ch.ten}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="form-label">Chức vụ:</label>
                        <select name="chucVu" class="form-select" aria-label="Default select example">
                            <c:forEach varStatus="i" items="${lstCV}" var="cv">
                                <option value="${cv.id}">${cv.ten}</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div>
                        <label class="form-label">Trạng thái:</label>
                        <select name="trangThai" class="form-select" aria-label="Default select example">
                            <option value="1">Đang làm việc</option>
                            <option value="0">Đã nghỉ</option>
                        </select>
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
    <div class="card text-bg-info card-header">Danh sách nhân viên</div>
    <div class="card-body">
        <table class="table align-middle table-bordered">
            <thead>
            <tr>
                <th scope="col" class="text-center">ID</th>
                <th scope="col" class="text-center">Mã</th>
                <th scope="col" class="text-center">Họ tên</th>
                <th scope="col" class="text-center">Giới tính</th>
                <th scope="col" class="text-center">Ngày sinh</th>
                <th scope="col" class="text-center">Địa chỉ</th>
                <th scope="col" class="text-center">Số điện thoại</th>
                <th scope="col" class="text-center">Mật khẩu</th>
                <th scope="col" class="text-center">Cửa hàng</th>
                <th scope="col" class="text-center">Chức vụ</th>
                <th scope="col" class="text-center">Trạng thái</th>
                <th scope="col" class="text-center"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="i" items="${lstNV}" var="nv">
                <tr>
                    <td scope="row" >${nv.id}</td>
                    <td>${nv.ma}</td>
                    <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.ngaySinh}</td>
                    <td >${nv.diaChi}</td>
                    <td>${nv.sdt}</td>
                    <td >${nv.matKhau}</td>
                    <td >${nv.idCH.ten}</td>
                    <td >${nv.idCV.ten}</td>
                    <td >${nv.trangThai ==1 ? "Đang làm việc" : "Đã nghỉ"}</td>
                    <td>
                        <a href="/nhan-vien/chi-tiet?id=${nv.id}"><button class="btn btn-primary">Xem</button></a>
                        <a href="/nhan-vien/xoa?id=${nv.id}"><button class="btn btn-danger">Xóa</button></a>
                    </td>



                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
