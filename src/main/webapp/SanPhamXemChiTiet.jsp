<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/1/2023
  Time: 3:40 PM
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
<form class="row g-3 col-lg-8" action="/san-pham/sua?id=${sp.id}" method="post" enctype="multipart/form-data">
  <div>
    <label for="validationDefault03" class="form-label">Hình ảnh:</label><br>
    <img id="anh123" class="mb-2" src="data:image/png;base64,${anh}" style="border-radius: 10px;" height="170px"
         width="315px">
    <input name="anh" type="file"  class="form-control" id="validationDefault03" onchange="xemTruocAnh(event)">

  </div>
  <div>
    <label for="validationDefault00" class="form-label">ID:</label>
    <input value="${sp.id}" name="id" type="text" class="form-control" id="validationDefault00" disabled>
  </div>
  <div>
    <label for="validationDefault01" class="form-label">Mã:</label>
    <input value="${sp.ma}" name="ma" type="text" class="form-control" id="validationDefault01" required>
  </div>
  <div>
    <label for="validationDefault02" class="form-label">Tên:</label>
    <input value="${sp.ten}" name="ten" type="text" class="form-control" id="validationDefault02" required>
  </div>

  <div class="d-flex justify-content-center align-items-center">
    <button class="btn btn-warning" type="submit">Sửa</button>
  </div>
</form>
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
    } else {
      // Nếu không có file mới được chọn, giữ nguyên nguồn của ảnh mặc định
      const imgElement = document.getElementById('anh123');
      imgElement.src = "data:image/png;base64,${anh}";
    }
  }
</script>
</body>
</html>
