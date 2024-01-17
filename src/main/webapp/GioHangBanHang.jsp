<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/2/2023
  Time: 2:54 PM
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
<div class="mt-3">
    <h3>Giỏ hàng</h3>
    <div class="card border-info mt-5" style="width: 100%;">
        <div class="card text-bg-info card-header">Danh sách giỏ hàng</div>
        <div class="card-body">
            <table class="table align-middle">
                <thead>
                <tr>
                    <th scope="col">Chọn</th>
                    <th scope="col">STT</th>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col"></th>
                    <th scope="col">Màu sắc</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Thành tiền</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach varStatus="i" items="${lstGH}" var="gh">
                    <tr>
                        <th>
                            <div class="form-check">
                                <input name="ch_${i.index}" class="form-check-input" value="${gh.id}" type="checkbox" onchange="luuGiaTri(this)">
                            </div>
                        </th>
                        <th scope="row">${i.index}</th>
                        <td>
                            <c:forEach items="${anh}" var="a">
                                <c:if test="${gh.id==a.key}">
                                    <img src="data:image/png;base64,${a.value}" height="50px" width="100px">
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>${gh.tenSP}</td>
                        <form class="row g-3" action="/ban-hang/sua-gio-hang?id=${gh.id}" method="post" id="myForm">
                            <td>
                            <select name="mau" class="form-select" aria-label="Default select example" onchange="submitForm()">
                                <c:forEach varStatus="i" items="${lstCTSP}" var="ct">
                                    <c:if test="${ct.idSP.id == gh.idCTSP.idSP.id}">
                                        <option value="${ct.id}"<c:if test="${gh.mauSac==ct.idMauSac.ten}">selected</c:if> >${ct.idMauSac.ten}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                            </td>
                            <td>
                                <c:forEach varStatus="i" items="${lstCTSP}" var="ct">
                                    <c:if test="${gh.idCTSP.id == ct.id}">
                                        <input type="hidden" id="slMax" value="${ct.soLuongTon}" required>
                                        <input id="sl" name="sl" min="1" max="${ct.soLuongTon}" type="number" class="form-control" style="width: 100px;" value="${gh.soLuong}" onchange="submitForm1()" required>
                                    </c:if>
                                </c:forEach>
                            </td>
                        </form>
                        <td>${gh.giaBan}</td>
                        <td>
                            <c:forEach items="${tong}" var="tong">
                                <c:if test="${gh.id==tong.key}"> ${tong.value}</c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal"><img src="/IMG/trash.svg"></button>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">XÓA</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <h3 class="text-center">Bạn chắc chắn muốn xóa?</h3>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                            <a href="/gio-hang/xoa?idGH=${gh.id}"><button type="button" class="btn btn-primary">Xóa</button></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
                <!-- Hiển thị thông báo nếu có -->
                <%
                    HttpSession session12 = request.getSession();
                    String successMessage12 = (String) session1.getAttribute("chuachon");
                    if (successMessage12 != null) {
                %>
                <p style="font-weight: bold; color: red">
                    <%= successMessage12 %>
                </p>
                <%
                        // Xóa thông báo sau khi đã hiển thị
                        session1.removeAttribute("chuachon");
                    } %>
            </table>

            <div class="d-flex justify-content-evenly align-items-center mt-5">
                <button type="button" class="btn btn-warning"><a class="navbar-brand" href="/ban-hang/trang-chu" style="color: whitesmoke;">Tiếp tục mua hàng</a></button>
                <h5>Tổng tiền: ${tongTien} đ</h5>
                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal123456">Thanh toán</button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal123456" tabindex="-1" aria-labelledby="exampleModalLabel123456" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel123456">THANH TOÁN</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h3 class="text-center">Bạn chắc chắn muốn thanh toán?</h3>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                <form class="row g-3" action="/gio-hang/thanh-toan" method="post" id="formTTGioHang">
                                    <input type="hidden" id="trong" name="trong" value="1">
                                    <button onclick="layGiaTri()" type="submit" class="btn btn-primary">Thanh toán</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function submitForm() {
        document.getElementById("myForm").submit();
    }
    function submitForm1() {
        var sl= document.getElementById("id").value;
        var slMax= document.getElementById("slMax").value;
        if(sl>0 && sl<=slMax){
            document.getElementById("myForm").submit();
        }
    }
    var giaTriTuCheckbox = []; // Mảng lưu trữ giá trị từ checkbox

    // Hàm lưu trữ giá trị từ checkbox khi thay đổi
    function luuGiaTri(checkbox) {
        if (checkbox.checked) {
            giaTriTuCheckbox.push(checkbox.value);
        } else {
            var index = giaTriTuCheckbox.indexOf(checkbox.value);
            if (index !== -1) {
                giaTriTuCheckbox.splice(index, 1);
            }
        }
    }
    function layGiaTri() {
        if(giaTriTuCheckbox.length>0){
            for (var i = 0; i < giaTriTuCheckbox.length; i++) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "chon_" + i;
                input.value= giaTriTuCheckbox[i];
                document.getElementById("formTTGioHang").appendChild(input);
            }
        }else{
            document.getElementById("trong").value=0;
        }
    }


</script>
</body>
</html>
