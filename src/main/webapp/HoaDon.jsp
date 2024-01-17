<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/5/2023
  Time: 3:17 PM
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
<body>
<div class="mt-3">
    <h3>Giỏ hàng</h3>
    <div class="card border-info mt-5" style="width: 100%;">
        <div class="card text-bg-info card-header">Danh sách hóa đơn</div>
        <div class="card-body">
            <table class="table align-middle">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">ID</th>
                    <th scope="col">Tên khách hàng</th>
                    <th scope="col">Ngày tạo</th>
                    <th scope="col">Tình trạng</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach varStatus="i" items="${lstHD}" var="hd">
                    <tr>
                        <th scope="row">${i.index}</th>
                        <th scope="row">${hd.id}}</th>
                        <td>${hd.idKH.ho} ${hd.idKH.tenDem} ${hd.idKH.ten}</td>
                        <td>${hd.ngayTao}</td>
                        <td>${hd.tinhTrang ==0 ? 'Đã thanh toán' : 'Chưa thanh toán'}</td>
                        <td><a href="/hoa-don/chi-tiet?id=${hd.id}"><button type="button" class="btn btn-primary">Xem chi tiết</button></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
