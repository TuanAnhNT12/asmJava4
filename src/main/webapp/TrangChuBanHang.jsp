<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/2/2023
  Time: 2:46 PM
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
<!--Header-->
<nav class=" navbar navbar-expand-lg bg-body-tertiary fixed-top" style=" width: 100%; background-color: #FBE8BD;">
  <div class="container-fluid d-flex justify-content-between align-items-center" style="background-color: #FBE8BD;">
    <div>
      <img src="/IMG/logo-removebg-preview.png" width="200px"  class="mr-5">
    </div>
    <div>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
              aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item"><a class="navbar-brand" href="/ban-hang/trang-chu">Trang chủ</a></li>
          <li class="nav-item"><a class="navbar-brand" href="">Giới thiệu</a></li>
          <li class="nav-item"><a class="navbar-brand" href="/ban-hang/san-pham">Sản phẩm</a></li>
        </ul>
      </div>
    </div>
    <div class="d-flex justify-content-center align-items-center">
      <a class="navbar-brand" href="" ><img src="/IMG/iconprofilenophong.gif" width="50" height="45"></a>
      <a class="navbar-brand" href="/ban-hang/hien-thi-gio-hang"><img src="/IMG/icongiohangnophong.gif" width="50" height="45"></a>
    </div>
  </div>
</nav>
<!-- Hết header -->

<!-- Nội dung chính -->
<div class=" mt-3">
  <h3>Trang chủ</h3>
  <img class="mt-2" src="/IMG/banner.png" width="100%">
  <!--SẢN PHẨM NỔI BẬT-->
  <h2 class="mt-5 d-flex justify-content-center align-items-center">SẢN PHẨM NỔI BẬT</h2>
  <div class="row">
    <c:forEach varStatus="i" items="${top4dau}" var="sp">
      <div class="col-lg-3 col-md-6 mt-5">
        <div class="card" style="width: 100%; height: 450px;">
          <c:forEach items="${doiAnh}" var="a">
            <c:if test="${sp.id == a.key}">
              <img src="data:image/png;base64,${a.value}" class="card-img-top"/>
            </c:if>
          </c:forEach>
          <hr class="border border-danger border-2 opacity-50">
          <div class="card-body">
            <h6 class="card-title mt-1"><a style="color: black; text-decoration: none; "
                                           href="/ban-hang/chi-tiet?id=${sp.id}">${sp.ten}</a></h6>
            <c:forEach items="${giaMin}" var="gia">
              <c:if test="${sp.id == gia.key}">
                <h4 class="text-center mt-5" style="color: red;">Từ: ${gia.value} đ</h4>
              </c:if>
            </c:forEach>

          </div>
        </div>
      </div>
    </c:forEach>
  </div>
  <!--SẢN PHẨM MỚI-->
  <h2 class="mt-5 d-flex justify-content-center align-items-center">SẢN PHẨM MỚI</h2>
  <div class="row">
    <c:forEach varStatus="i" items="${top4cuoi}" var="sp">
      <div class="col-lg-3 col-md-6 mt-5">
        <div class="card" style="width: 100%; height: 450px;">
          <c:forEach items="${doiAnh}" var="a">
            <c:if test="${sp.id == a.key}">
              <img src="data:image/png;base64,${a.value}" class="card-img-top"/>
            </c:if>
          </c:forEach>
          <hr class="border border-danger border-2 opacity-50">
          <div class="card-body">
            <h6 class="card-title mt-1"><a style="color: black; text-decoration: none; "
                                           href="/ban-hang/chi-tiet?id=${sp.id}">${sp.ten}</a></h6>
            <c:forEach items="${giaMin}" var="gia">
              <c:if test="${sp.id == gia.key}">
                <h4 class="text-center mt-5" style="color: red;">Từ: ${gia.value} đ</h4>
              </c:if>
            </c:forEach>

          </div>
        </div>
      </div>
    </c:forEach>
  </div>
  <img class="mt-5" src="/IMG/banner2.jpg" width="100%">
</div>
<!-- Kết thúc nội dung chính -->

<!-- Footer -->
<div>
  <footer style="background-color: #87ACD9; width: 100%; height: 90px;"
          class="d-flex justify-content-center align-items-center mt-5">
    <h2>Nguyễn Hoàng Tuấn Anh - PH30259</h2>
  </footer>
</div>
<!-- Hết Footer -->
</body>
</html>
