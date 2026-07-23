<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="entity.User"%>
<%@ page import="entity.Website"%>
<%@ page import="java.util.List"%>

<%
User user = (User) session.getAttribute("user");

List<Website> websites =
(List<Website>) request.getAttribute("websites");
%>

<!DOCTYPE html>
<html lang="vi">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Dashboard | Make Web Now</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/dashboard.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>

<body>

<!-- Navbar -->

<nav class="navbar navbar-expand-lg bg-white shadow-sm">

<div class="container">

<a class="navbar-brand fw-bold logo" href="#">

 Make Web Now

</a>

<form class="d-flex w-50">

<input class="form-control search-box"

type="search"

placeholder="Tìm kiếm template...">

</form>

<div>

<span class="me-3">

Xin chào,

<b><%=user.getFullName()%></b>

</span>

<a href="${pageContext.request.contextPath}/logout"

class="btn btn-outline-danger">

Đăng xuất

</a>

</div>

</div>

</nav>

<!-- Content -->

<div class="container mt-5">

<div class="hero">

<h1>

Thiết kế website chưa bao giờ dễ đến thế 

</h1>

<p>

Kéo thả Block như Scratch và tạo website chỉ trong vài phút.

</p>

<a href="${pageContext.request.contextPath}/template" class="btn btn-create">

+ Tạo Website Mới

</a>

</div>

<h3 class="mt-5 mb-4">

Website của bạn

</h3>

<%
if(websites == null || websites.isEmpty()){
%>

<div class="alert alert-light border">

    Bạn chưa tạo website nào.

</div>

<%
}else{
%>

<div class="row">

<%
for(Website w : websites){
%>

<div class="col-md-4 mb-4">

    <div class="card shadow-sm h-100">

        <div class="card-body">

            <h5>

                <%= w.getWebsiteName() %>

            </h5>

            <p class="text-muted">

                <%= w.getDescription() %>

            </p>

            <small class="text-secondary">

                Lưu lần cuối:
                <%= w.getLastSaved() %>

            </small>

            <br><br>

            <a href="${pageContext.request.contextPath}/editor?websiteID=<%=w.getWebsiteID()%>"

               class="btn btn-primary">

                Chỉnh sửa

            </a>

        </div>

    </div>

</div>

<%
}
%>

</div>

<%
}
%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>