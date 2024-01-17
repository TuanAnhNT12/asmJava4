<%--
  Created by IntelliJ IDEA.
  User: ttuan
  Date: 12/2/2023
  Time: 4:54 PM
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
<body class="container-fluid ">
<div class="mt-3">
    <h3>Sản phẩm</h3>
    <div class="row">
        <div class="col-md-3 col-lg-3 mt-5">
            <div class="card" style="width: 100%; height: auto;">
                <div class="card-header">
                    <h4>Dòng sản phẩm</h4>
                </div>
                <ul class="list-group list-group-flush">
                    <c:forEach items="${lstDSP}" var="dsp">
                    <li value="${dsp.id}" class="list-group-item" >
                        <a href="" class="navbar-brand">${dsp.ten}</a>
                    </li>
                    </c:forEach>
                </ul>

            </div>

        </div>
        <div class="col-md-9 col-lg-9">
            <div class="input-group input-group-lg mt-5">
                <span class="input-group-text" id="inputGroup-sizing-lg"><img src="/IMG/timkiemnophong.gif" width="40px"
                                                                              height="35px"></span>
                <input placeholder="Nhập tên sản phẩm muốn tìm kiếm" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            </div>
            <div class="row">
                <c:forEach varStatus="i" items="${lstSP}" var="sp">
                    <div class="col-lg-4 col-md-6 mt-5">
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

        </div>

    </div>
</div>
</body>
</html>
