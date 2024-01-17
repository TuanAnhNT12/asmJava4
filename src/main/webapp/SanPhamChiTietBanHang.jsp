<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/2/2023
  Time: 5:22 PM
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
<div>
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
</div>
<div>
    <!-- Hiển thị thông báo nếu có -->
    <%
        HttpSession session121 = request.getSession();
        String successMessag = (String) session1.getAttribute("successMessag");
        if (successMessag != null) {
    %>
    <div class="alert alert-warning">
        <%= successMessag %>
    </div>

    <%
            // Xóa thông báo sau khi đã hiển thị
            session121.removeAttribute("successMessag");

        } %>
</div>
    <!--Tên sản phẩm-->
    <h5 name="tenSP" class="mt-5">${sp.ten}</h5>
    <hr>
    <div class="row mt-3">
        <div class="col-lg-6 col-md-6">
            <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel" style="width: 100%;">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <!--Ảnh sản phẩm-->
                        <img src="data:image/png;base64,${anh}" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <div class="d-flex justify-content-center align-items-center mt-4">
                <div>
                    <!-- thẻ a trigger modal -->
                    <a style="color: black; text-decoration: none; width: 66px;" href="" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <div class="card border-light mb-3" style="max-width: 6rem;">
                            <div class="card-body">
                                <img src="/IMG/mohop.gif" width="100%" class="card-img-top">
                                <p class="card-text text-center" style="font-size: 14px;">Hình mở hộp</p>
                            </div>
                        </div>
                    </a>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel1"
                         aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel1">Hình ảnh mở hộp</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <img src="/IMG/hinhmohopasusnoibat1.jpg" width="100%">
                                    <div class="card border-light" style="width: 100%;">
                                        <div class="card-header">Bộ sản phẩm gồm: Sách hướng dẫn, Thùng máy, Sạc Laptop</div>

                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <!-- thẻ a trigger modal -->
                    <a style="color: black; text-decoration: none; width: 66px;" href="" data-bs-toggle="modal" data-bs-target="#exampleModal2">
                        <div class="card border-light mb-3" style="max-width: 6rem;">
                            <div class="card-body">
                                <img src="/IMG/thongso.gif" width="100%" class="card-img-top">
                                <p class="card-text text-center" style="font-size: 14px;">Thông số kỹ thuật</p>
                            </div>
                        </div>
                    </a>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel2"
                         aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel2">Thông số kỹ thuật</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="card border-light" style="width: 100%;">
                                        <div class="card-body">
                                            <table class="table">
                                                <tbody>
                                                <tr>
                                                    <th scope="row">CPU:</th>
                                                    <td>i5, 11400H, 2.7GHz</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">RAM:</th>
                                                    <td>8 GBDDR4 2 khe (1 khe 8 GB + 1 khe rời)3200 MHz</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Ổ cứng:</th>
                                                    <td>Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng (nâng cấp tối đa 1 TB)512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1 TB)</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Màn hình:</th>
                                                    <td>15.6"Full HD (1920 x 1080) 144Hz</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Card màn hình:</th>
                                                    <td>Card rời, RTX 2050 4GB</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Cổng kết nối:</th>
                                                    <td>1 x Thunderbolt 4 (hỗ trợ DisplayPort), HDMI, LAN (RJ45), 3 x USB 3.2, Jack tai nghe 3.5 mm</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Đặc biệt:</th>
                                                    <td>Có đèn bàn phím</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Hệ điều hành:</th>
                                                    <td>Windows 11 Home SL</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Thiết kế:</th>
                                                    <td>Vỏ nhựa - nắp lưng bằng kim loại</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Kích thước, khối lượng:</th>
                                                    <td>Dài 359 mm - Rộng 256 mm - Dày 22.8 ~ 24.5 mm - Nặng 2.3 kg</td>
                                                </tr>

                                                <tr>
                                                    <th scope="row">Thời điểm ra mắt:</th>
                                                    <td>2023</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <!-- thẻ a trigger modal -->
                    <a style="color: black; text-decoration: none; width: 66px;" href="" data-bs-toggle="modal" data-bs-target="#exampleModal3">
                        <div class="card border-light mb-3" style="max-width: 6rem;">
                            <div class="card-body">
                                <img src="/IMG/thongtin.gif" width="100%" class="card-img-top">
                                <p class="card-text text-center" style="font-size: 14px;">Thông tin sản phẩm</p>
                            </div>
                        </div>
                    </a>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Thông tin sản phẩm</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="card border-light" style="width: 100%;">
                                        <div class="card-body">
                                            <!--tên-->
                                            <h4 class="card-title">Thông tin nổi bật của sản phẩm ${sp.ten}</h4>
                                            <ul>
                                                <li class="card-text">Với bộ vi xử lý Intel Core i5 11400H có tốc độ lên đến 4.5 GHz, chiếc
                                                    laptop Asus TUF Gaming này đảm bảo hoạt động mượt mà và có thể đáp ứng tốt các tác vụ đa
                                                    nhiệm, mang lại trải nghiệm sử dụng tuyệt vời trong cả công việc lẫn giải trí, chiến game ở
                                                    mức cấu hình cao.</li>
                                                <li class="card-text">Asus TUF Gaming F15 được trang bị card đồ họa NVIDIA GeForce RTX 2050 với
                                                    bộ nhớ đồ họa 4 GB, giúp đáp ứng tốt nhu cầu chơi game cấu hình cao và xử lý các file thiết
                                                    kế nặng. Từ đó mang lại cho người dùng trải nghiệm chơi game đỉnh cao và hiệu suất làm việc
                                                    mượt mà.</li>
                                                <li class="card-text">Bộ nhớ RAM 8 GB DDR4 với khả năng nâng cấp tối đa lên đến 32 GB đáp ứng
                                                    nhu cầu chạy đa nhiệm mượt mà, cho bạn tận hưởng những giây phút chiến game đỉnh cao khi có
                                                    thể mở nhiều ứng dụng từ nghe nhạc, xem phim, game nặng cùng lúc.</li>
                                                <li class="card-text">Với ổ cứng SSD 512 GB, bạn không cần phải lo lắng về dung lượng lưu trữ và
                                                    đồng thời tận hưởng tốc độ khởi động nhanh chóng cùng khả năng tải ứng dụng mượt mà của
                                                    chiếc laptop gaming.</li>
                                                <li class="card-text">Màn hình 15.6 inch độ phân giải Full HD (1920 x 1080) và tốc độ làm mới
                                                    144 Hz mang lại hình ảnh sắc nét và mượt mà, cho trải nghiệm chơi game tuyệt vời, đặc biệt
                                                    là các game có tốc độ khung hình cao. Đồng thời tính năng chống chói Anti Glare giúp hạn chế
                                                    hiện tượng ánh sáng phản chiếu khi sử dụng trong điều kiện ánh sáng mạnh.</li>
                                                <li class="card-text">Bên cạnh đó, laptop còn được trang bị hệ thống âm thanh DTS software tiên
                                                    tiến, mang lại cho bạn trải nghiệm âm thanh sống động và chân thực hơn bao giờ hết khi sử
                                                    dụng.</li>
                                                <li class="card-text">Laptop Asus còn có lối thiết kế hầm hố với sắc đen nam tính, tạo nên sự
                                                    mạnh mẽ và đậm tính thể thao. Điểm nhấn của bàn phím là đèn nền RGB có thể chuyển đổi màu
                                                    sắc, tạo điểm nhấn độc đáo khi sử dụng nơi đông người.</li>
                                                <li class="card-text">Máy có nhiều cổng giao tiếp hữu ích: Thunderbolt 4, Jack tai nghe 3.5 mm,
                                                    USB 3.2, HDMI và LAN (RJ45).</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="card mt-3" style="width: 100%;">
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="d-flex justify-content-between">
                                <img src="/IMG/icondoihang.gif" width="35" height="30">
                                <p class="card-text">Hư gì đổi nấy 12 tháng
                                    tại 3361 siêu thị toàn quốc (miễn phí tháng đầu)</p>
                            </div>

                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="d-flex justify-content-between">
                                <img src="/IMG/iconkhien.gif" width="35" height="30">
                                <p class="card-text">Bảo hành chính hãng
                                    laptop 2 năm tại các trung tâm bảo hành hãng</p>
                            </div>
                        </div>
                        <hr class="mt-3 mb-3">
                        <div class="col-lg-6 col-md-6">
                            <div class="d-flex justify-content-between">
                                <img src="/IMG/iconhang.gif" width="35" height="30">
                                <p class="card-text">Bộ sản phẩm gồm: Sách
                                    hướng dẫn, Thùng máy, Sạc Laptop Asus ( 150W )</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card text-bg-light mt-5" style="width: 100%;">
                <div class="card-header">Đặc điểm nổi bật</div>
                <div class="card-body">
                    <!--Tên sản phẩm-->
                    <h4 class="card-title">Thông tin nổi bật của sản phẩm ${sp.ten}.</h4>
                    <ul>
                        <li class="card-text">Với bộ vi xử lý Intel Core i5 11400H có tốc độ lên đến 4.5 GHz, chiếc
                            laptop Asus TUF Gaming này đảm bảo hoạt động mượt mà và có thể đáp ứng tốt các tác vụ đa
                            nhiệm, mang lại trải nghiệm sử dụng tuyệt vời trong cả công việc lẫn giải trí, chiến game ở
                            mức cấu hình cao.</li>
                        <li class="card-text">Asus TUF Gaming F15 được trang bị card đồ họa NVIDIA GeForce RTX 2050 với
                            bộ nhớ đồ họa 4 GB, giúp đáp ứng tốt nhu cầu chơi game cấu hình cao và xử lý các file thiết
                            kế nặng. Từ đó mang lại cho người dùng trải nghiệm chơi game đỉnh cao và hiệu suất làm việc
                            mượt mà.</li>
                        <li class="card-text">Bộ nhớ RAM 8 GB DDR4 với khả năng nâng cấp tối đa lên đến 32 GB đáp ứng
                            nhu cầu chạy đa nhiệm mượt mà, cho bạn tận hưởng những giây phút chiến game đỉnh cao khi có
                            thể mở nhiều ứng dụng từ nghe nhạc, xem phim, game nặng cùng lúc.</li>
                        <li class="card-text">Với ổ cứng SSD 512 GB, bạn không cần phải lo lắng về dung lượng lưu trữ và
                            đồng thời tận hưởng tốc độ khởi động nhanh chóng cùng khả năng tải ứng dụng mượt mà của
                            chiếc laptop gaming.</li>
                        <li class="card-text">Màn hình 15.6 inch độ phân giải Full HD (1920 x 1080) và tốc độ làm mới
                            144 Hz mang lại hình ảnh sắc nét và mượt mà, cho trải nghiệm chơi game tuyệt vời, đặc biệt
                            là các game có tốc độ khung hình cao. Đồng thời tính năng chống chói Anti Glare giúp hạn chế
                            hiện tượng ánh sáng phản chiếu khi sử dụng trong điều kiện ánh sáng mạnh.</li>
                        <li class="card-text">Bên cạnh đó, laptop còn được trang bị hệ thống âm thanh DTS software tiên
                            tiến, mang lại cho bạn trải nghiệm âm thanh sống động và chân thực hơn bao giờ hết khi sử
                            dụng.</li>
                        <li class="card-text">Laptop Asus còn có lối thiết kế hầm hố với sắc đen nam tính, tạo nên sự
                            mạnh mẽ và đậm tính thể thao. Điểm nhấn của bàn phím là đèn nền RGB có thể chuyển đổi màu
                            sắc, tạo điểm nhấn độc đáo khi sử dụng nơi đông người.</li>
                        <li class="card-text">Máy có nhiều cổng giao tiếp hữu ích: Thunderbolt 4, Jack tai nghe 3.5 mm,
                            USB 3.2, HDMI và LAN (RJ45).</li>
                    </ul>
                </div>
            </div>


        </div>
        <div class="col-lg-6 col-md-6">
            <form class="row g-3" action="/ban-hang/chi-tiet" method="get" id="myForm">
                <div>
                    <label class="form-label" style="font-weight: bold;">Màu sắc:</label>
                    <select  name="mauSP" class="form-select" aria-label="Default select example" onchange="submitForm()">
                    <c:forEach varStatus="i" items="${ctsp}" var="ct">
                        <option value="${ct.key}" <c:if test="${mau==ct.value.idMauSac.ten}">selected</c:if> >${ct.value.idMauSac.ten}</option>

                    </c:forEach>
                </select>
                </div>
            </form>

            <!--giá sản phẩm-->
            <p class="card-text mt-2" style="font-weight: bold;">Giá bán:</p>
            <h5 name="giaSP" class="card-text" style="color: red;"> ${gia} đ</h5>
            <p name="soLuongSP" class="card-text">Còn hàng: ${sl} sản phẩm</p>
            <img class="mb-3 mt-3" src="/IMG/giamgia1.png" width="100%">
            <img class="mb-3" src="/IMG/giamgia2.webp" width="100%">
            <div class="d-flex justify-content-between align-items-center mt-4">
                <form class="row g-3" action="/ban-hang/chi-tiet" method="get" >
                    <button data-bs-toggle="modal" data-bs-target="#exampleModal123" type="button" class="btn btn-danger" style="width: 100%; height: 40px;">Mua ngay</button>
                </form>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal123" tabindex="-1" aria-labelledby="exampleModalLabel123" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form class="row g-3" action="/chi-tiet-san-pham/thanh-toan?idCTSP=${idCTSP}" method="post" >
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel123">THANH TOÁN</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">

                                    <div class="card mb-3" style="width: 100%;">
                                        <div class="row g-0">
                                            <div class="col-md-5">
                                                <img src="data:image/png;base64,${anh}" class="img-fluid rounded-start" alt="...">
                                            </div>
                                            <div class="col-md-7">
                                                <div class="card-body">
                                                    <h5 class="card-title">${sp.ten}</h5>
                                                    Màu sắc:<p class="card-text"> ${mau}</p>
                                                    Giá:<p class="card-text"> ${gia}</p>
                                                    Số lượng:<input name="slTT" type="number" max="${sl}" class="form-control" min="1" value="1">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                    <button type="submit" class="btn btn-primary">Mua ngay</button>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>

                <form class="row g-3" action="/ban-hang/them-gio-hang" method="post" id="secondForm">
                    <input type="hidden" name="mauSPPost" id="mauSPPost" value="">
                    <input type="hidden" name="aabb"  value="${sp.id}">
                    <button type="submit" class="btn btn-outline-danger" style="width: 100%; height: 40px;" onclick="dulieu()">Thêm vào giỏ</button>
                </form>



            </div>
            <div class="card border-light mt-5" style="width: 100%;">
                <!--Tên cấu hình-->
                <div class="card-header"><h5>Cấu hình ${sp.ten}</h5></div>
                <div class="card-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th scope="row">CPU:</th>
                            <td>i5, 11400H, 2.7GHz</td>
                        </tr>
                        <tr>
                            <th scope="row">RAM:</th>
                            <td>8 GB, DDR4 2 khe (1 khe 8 GB + 1 khe rời), 3200 MHz</td>
                        </tr>
                        <tr>
                            <th scope="row">Ổ cứng:</th>
                            <td>Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng (nâng cấp tối đa 1 TB), 512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1 TB)</td>
                        </tr>
                        <tr>
                            <th scope="row">Màn hình:</th>
                            <td>15.6"Full HD (1920 x 1080) 144Hz</td>
                        </tr>
                        <tr>
                            <th scope="row">Card màn hình:</th>
                            <td>Card rời, RTX 2050 4GB</td>
                        </tr>
                        <tr>
                            <th scope="row">Cổng kết nối:</th>
                            <td>1 x Thunderbolt 4 (hỗ trợ DisplayPort), HDMI, LAN (RJ45), 3 x USB 3.2, Jack tai nghe 3.5 mm</td>
                        </tr>
                        <tr>
                            <th scope="row">Đặc biệt:</th>
                            <td>Có đèn bàn phím</td>
                        </tr>
                        <tr>
                            <th scope="row">Hệ điều hành:</th>
                            <td>Windows 11 Home SL</td>
                        </tr>
                        <tr>
                            <th scope="row">Thiết kế:</th>
                            <td>Vỏ nhựa - nắp lưng bằng kim loại</td>
                        </tr>
                        <tr>
                            <th scope="row">Kích thước, khối lượng:</th>
                            <td>Dài 359 mm - Rộng 256 mm - Dày 22.8 ~ 24.5 mm - Nặng 2.3 kg</td>
                        </tr>

                        <tr>
                            <th scope="row">Thời điểm ra mắt:</th>
                            <td>2023</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>

<script>
    function submitForm() {
        document.getElementById("myForm").submit();

    }
    function dulieu(){
        var selectedValue = document.getElementById("myForm").elements["mauSP"].value;
        document.getElementById("mauSPPost").value = selectedValue;
    }
</script>
</body>
</html>
