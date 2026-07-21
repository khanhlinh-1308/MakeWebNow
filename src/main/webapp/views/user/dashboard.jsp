<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="entity.User"%>

<%
User user = (User) session.getAttribute("user");
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

Template nổi bật

</h3>

<div class="row">

<div class="col-md-3">

<div class="template-card">

<img src="https://placehold.co/400x240"

class="img-fluid">

<h5>Portfolio</h5>

</div>

</div>

<div class="col-md-3">

<div class="template-card">

<img src="https://placehold.co/400x240"

class="img-fluid">

<h5>Landing Page</h5>

</div>

</div>

<div class="col-md-3">

<div class="template-card">

<img src="https://placehold.co/400x240"

class="img-fluid">

<h5>Shop</h5>

</div>

</div>

<div class="col-md-3">

<div class="template-card">

<img src="https://placehold.co/400x240"

class="img-fluid">

<h5>Blog</h5>

</div>

</div>

</div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>