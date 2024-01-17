<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/2/2023
  Time: 1:24 PM
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
<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">CHI TIẾT SẢN PHẨM CHI TIẾT</h2>
<form class="row g-3" action="/chi-tiet-sp/sua?id=${ctsp.id}" method="post">
    <div>
        <label class="form-label">Sản phẩm:</label>
        <select name="sp" class="form-select" aria-label="Default select example">
            <c:forEach varStatus="i" items="${lstSP}" var="sp">
                <option value="${sp.id}" <c:if test="${ctsp.idSP.ten == sp.ten}">selected</c:if> >${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label class="form-label">Nơi sản xuất:</label>
        <select name="nsx" class="form-select" aria-label="Default select example">
            <c:forEach varStatus="i" items="${lstNSX}" var="nsx">
                <option value="${nsx.id}" <c:if test="${ctsp.idNsx.ten == nsx.ten}">selected</c:if> >${nsx.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label class="form-label">Màu sắc:</label>
        <select name="ms" class="form-select" aria-label="Default select example">
            <c:forEach varStatus="i" items="${lstMS}" var="ms">
                <option value="${ms.id}" <c:if test="${ctsp.idMauSac.ten == ms.ten}">selected</c:if> >${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label class="form-label">Dòng sản phẩm:</label>
        <select name="dsp" class="form-select" aria-label="Default select example">
            <c:forEach varStatus="i" items="${lstDSP}" var="dsp">
                <option value="${dsp.id}" <c:if test="${ctsp.idDongSP.ten == dsp.ten}">selected</c:if> >${dsp.ten}</option>
            </c:forEach>
        </select>
    </div>

    <div>
        <label class="form-label">Năm bảo hành:</label>
        <input value="${ctsp.namBH}" name="nbh" type="number" class="form-control" required>
    </div>
    <div>
        <label class="form-label">Mô tả:</label>
        <input value="${ctsp.moTa}" name="mt" type="text" class="form-control">
    </div>
    <div>
        <label class="form-label">Số lượng tồn:</label>
        <input value="${ctsp.soLuongTon}" name="slt" type="text" class="form-control">
    </div>
    <div>
        <label class="form-label">Giá nhập:</label>
        <input value="${ctsp.giaNhap}" name="gn" type="number" class="form-control">
    </div>
    <div>
        <label class="form-label">Giá bán:</label>
        <input value="${ctsp.giaBan}" name="gb" type="number" class="form-control">
    </div>
    <div class="d-flex justify-content-center align-items-center">
        <button class="btn btn-warning" type="submit">Cập nhật</button>
    </div>
</form>
</body>
</html>
