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
    <title>Title</title>
    <!--Nhúng Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</head>

<body class="container-fluid">

<!-- Hiển thị thông báo nếu có -->
<%
    HttpSession session1 = request.getSession();
    String successMessage = (String) session1.getAttribute("successMessage");
    if (successMessage != null) {
%>
<div class="alert alert-success">
    <%= successMessage %>
</div>
<%
        // Xóa thông báo sau khi đã hiển thị
        session1.removeAttribute("successMessage");
    } %>

<h2 class="d-flex justify-content-center align-items-center mt-5 mb-5">CHI TIẾT SẢN PHẨM</h2>
<div class="d-flex justify-content-end align-items-center">
    <button type="button" class="btn btn-success mt-20 mb-4" data-bs-toggle="modal" data-bs-target="#exampleModal">+ Thêm chi tiết SP</button>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Nhập thông tin chi tiết sản phẩm</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="row g-3" action="/chi-tiet-sp/them" method="post">
                    <div>
                        <label class="form-label">Sản phẩm:</label>
                        <select name="sp" class="form-select" aria-label="Default select example">
                            <c:forEach varStatus="i" items="${lstSP}" var="sp">
                                <option value="${sp.id}">${sp.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label class="form-label">Nơi sản xuất:</label>
                        <select name="nsx" class="form-select" aria-label="Default select example">
                            <c:forEach varStatus="i" items="${lstNSX}" var="nsx">
                                <option value="${nsx.id}">${nsx.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label class="form-label">Màu sắc:</label>
                        <select name="ms" class="form-select" aria-label="Default select example">
                            <c:forEach varStatus="i" items="${lstMS}" var="ms">
                                <option value="${ms.id}">${ms.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label class="form-label">Dòng sản phẩm:</label>
                        <select name="dsp" class="form-select" aria-label="Default select example">
                            <c:forEach varStatus="i" items="${lstDSP}" var="dsp">
                                <option value="${dsp.id}">${dsp.ten}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label class="form-label">Năm bảo hành:</label>
                        <input name="nbh" type="number" class="form-control" required>
                    </div>
                    <div>
                        <label class="form-label">Mô tả:</label>
                        <input name="mt" type="text" class="form-control">
                    </div>
                    <div>
                        <label class="form-label">Số lượng tồn:</label>
                        <input name="slt" type="text" class="form-control">
                    </div>
                    <div>
                        <label class="form-label">Giá nhập:</label>
                        <input name="gn" type="number" class="form-control">
                    </div>
                    <div>
                        <label class="form-label">Giá bán:</label>
                        <input name="gb" type="number" class="form-control">
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
    <div class="card text-bg-info card-header">Danh sách dòng sản phẩm</div>
    <div class="card-body">
        <table class="table align-middle table-bordered">
            <thead>
            <tr>
                <th scope="col" class="text-center">ID</th>
                <th scope="col" class="text-center">Sản phẩm</th>
                <th scope="col" class="text-center">Nhà sản xuất</th>
                <th scope="col" class="text-center">Màu sắc</th>
                <th scope="col" class="text-center">Dòng sản phẩm</th>
                <th scope="col" class="text-center">Năm bảo hành</th>
                <th scope="col" class="text-center">Mô tả</th>
                <th scope="col" class="text-center">Số lượng tồn</th>
                <th scope="col" class="text-center">Giá nhập</th>
                <th scope="col" class="text-center">Giá bán</th>
                <th scope="col" class="text-center"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="i" items="${lstCTSP}" var="ctsp">
                <tr>
                    <td scope="row" >${ctsp.id}</td>
                    <td>${ctsp.idSP.ten}</td>
                    <td>${ctsp.idNsx.ten}</td>
                    <td>${ctsp.idMauSac.ten}</td>
                    <td>${ctsp.idDongSP.ten}</td>
                    <td>${ctsp.namBH}</td>
                    <td>${ctsp.moTa}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.giaNhap}</td>
                    <td >${ctsp.giaBan}</td>
                    <td>
                        <a href="/chi-tiet-sp/chi-tiet?id=${ctsp.id}"><button class="btn btn-primary">Xem</button></a>
                        <a href="/chi-tiet-sp/xoa?id=${ctsp.id}"><button class="btn btn-danger" >Xóa</button></a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>

</html>
