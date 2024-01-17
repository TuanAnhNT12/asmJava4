<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/5/2023
  Time: 3:58 PM
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
<div class="mt-3">
    <h3>CHI TIẾT HÓA ĐƠN</h3>
    <div class="card border-info mt-5" style="width: 100%;">
        <div class="card text-bg-info card-header">Thông tin chi tiết hóa đơn</div>
        <div class="card-body">

            <div>
                <label class="form-label">ID hóa đơn: ${hd.id}</label><br>
                <label class="form-label">Tên khách hàng: ${hd.idKH.ho} ${hd.idKH.tenDem} ${hd.idKH.ten}</label><br>
                <label class="form-label">Ngày tạo: ${hd.ngayTao}</label><br>
                <label class="form-label">Tình trạng: ${hd.tinhTrang ==0 ? 'Đã thanh toán':'Chưa thanh toán'}</label><br>
            </div>

            <h4>Các sản phẩm trong hóa đơn:</h4>

            <table class="table align-middle">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col"></th>
                    <th scope="col">Màu sắc</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Đơn giá</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach varStatus="i" items="${lstHDCT}" var="hdct">
                    <tr>
                        <th scope="row">${i.index}</th>
                        <th scope="row">
                            <c:forEach varStatus="i" items="${anh}" var="anh">
                                <c:if test="${anh.key==hdct.id}"><img src="data:image/png;base64,${anh.value}" height="45px" width="90px"/></c:if>
                            </c:forEach>

                        </th>
                        <th scope="row">
                            <c:forEach varStatus="i" items="${ten}" var="ten">
                                <c:if test="${ten.key==hdct.id}">${ten.value}</c:if>
                            </c:forEach>

                        </th>
                        <c:if test=""></c:if>
                        <td>
                            <c:forEach varStatus="i" items="${mau}" var="mau">
                                <c:if test="${mau.key==hdct.id}">${mau.value}</c:if>
                            </c:forEach>
                        </td>
                        <td>${hdct.soLuong}</td>
                        <td>${hdct.donGia}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <h3 class="d-flex justify-content-end align-items-center" style="color: red">Tổng tiền: ${tong} đ</h3>
        </div>
    </div>
</div>
<body>

</body>
</html>
