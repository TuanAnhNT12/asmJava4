<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 11/30/2023
  Time: 10:01 AM
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
<body class="container- fluid">
<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">NHÂN VIÊN CHI TIẾT</h2>
<form class="row g-3 col-lg-8 mt-3" action="/nhan-vien/sua?id=${nv.id}" method="post">
    <div>
        <label for="validationDefault00" class="form-label">ID:</label>
        <input value="${nv.id}" name="id" type="text" class="form-control" id="validationDefault00" disabled>
    </div>
    <div>
        <label for="validationDefault01" class="form-label">Mã:</label>
        <input value="${nv.ma}" name="ma" type="text" class="form-control" id="validationDefault01" required>
    </div>
    <div>
        <label for="validationDefaulta" class="form-label">Họ:</label>
        <input value="${nv.ho}" name="ho" type="text" class="form-control" id="validationDefaulta" required>
    </div>
    <div>
        <label for="validationDefault02" class="form-label">Tên đệm:</label>
        <input value="${nv.tenDem}" name="tenDem" type="text" class="form-control" id="validationDefault02" required>
    </div>
    <div>
        <label for="validationDefault10" class="form-label">Tên:</label>
        <input value="${nv.ten}" name="ten" type="text" class="form-control" id="validationDefault10" required>
    </div>
    <div>
        <label class="form-label">Giới tính:</label>
        <div class="d-flex justify-content-start">
            <div class="form-check">
                <input name="gioiTinh" value="Nam" class="form-check-input" type="radio"  id="flexRadioDefault1" <c:if test="${nv.gioiTinh == 'Nam'}">checked</c:if>>

                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input name="gioiTinh" value="Nữ" class="form-check-input" type="radio" id="flexRadioDefault2" <c:if test="${nv.gioiTinh == 'Nữ'}">checked</c:if>>
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
        </div>
    </div>
    <div>
        <label for="validationDefault13" class="form-label">Ngày sinh:</label>
        <input value="${nv.ngaySinh}" name="ngaySinh" type="date" class="form-control" id="validationDefault13" required>
    </div>

    <div>
        <label for="validationDefault03" class="form-label">Địa chỉ:</label>
        <input value="${nv.diaChi}" name="diaChi" type="text" class="form-control" id="validationDefault03" required>
    </div>
    <div>
        <label for="validationDefault04" class="form-label">Số điện thoại:</label>
        <input value="${nv.sdt}" name="sdt" type="text" class="form-control" id="validationDefault04" required>
    </div>
    <div>
        <label for="validationDefault05" class="form-label">Mật khẩu:</label>
        <input value="${nv.matKhau}" name="mk" type="text" class="form-control" id="validationDefault05" required>
    </div>

    <div>
        <label class="form-label">Cửa hàng:</label>
        <select name="cuaHang" class="form-select" aria-label="Default select example">
            <c:forEach varStatus="i" items="${lstCH}" var="ch">
                <option value="${ch.id}" <c:if test="${nv.idCH.ten == ch.ten}">selected</c:if>>${ch.ten}</option>
            </c:forEach>
        </select>

    </div>

    <div>
        <label class="form-label">Chức vụ:</label>
        <select name="chucVu" class="form-select" aria-label="Default select example">
            <c:forEach varStatus="i" items="${lstCV}" var="cv">
                <option value="${cv.id}" <c:if test="${nv.idCV.ten == cv.ten}">selected</c:if>>${cv.ten}</option>
            </c:forEach>

        </select>
    </div>
    <div>
        <label class="form-label">Trạng thái:</label>
        <select name="trangThai" class="form-select" aria-label="Default select example">
            <option value="1" <c:if test="${nv.trangThai==1}">selected</c:if>>Đang làm việc</option>
            <option value="0" <c:if test="${nv.trangThai==0}">selected</c:if>>Đã nghỉ</option>
        </select>
    </div>
    <div class="d-flex justify-content-center align-items-center">
        <button class="btn btn-warning" type="submit">Cập nhật</button>
    </div>
</form>
</body>
</html>
