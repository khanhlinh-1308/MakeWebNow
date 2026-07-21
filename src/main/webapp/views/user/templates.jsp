<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.Template"%>

<%
List<Template> templates = (List<Template>)request.getAttribute("templates");
%>

<!DOCTYPE html>
<html lang="vi">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Template | Make Web Now</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/template.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>

<body>

<nav class="navbar navbar-expand-lg bg-white shadow-sm">

<div class="container">

<a class="navbar-brand logo fw-bold"
href="${pageContext.request.contextPath}/dashboard">

 Make Web Now

</a>

<form class="d-flex w-50">

<input
id="searchInput"
class="form-control search-box"
type="search"
placeholder="Tìm kiếm template...">

</form>

<a href="${pageContext.request.contextPath}/dashboard"
class="btn btn-outline-secondary">

Quay lại

</a>

</div>

</nav>

<div class="container mt-5">

<h2 class="fw-bold">

Chọn Template

</h2>

<p class="text-muted">

Bắt đầu bằng một template có sẵn.

</p>

<div class="row mt-4">

<%
if(templates!=null){

for(Template t : templates){
%>

<div class="col-lg-3 col-md-4 mb-4 template-item">

<div class="template-card">

<img
src="https://placehold.co/600x400/f8d4e8/ffffff?text=Template"
class="img-fluid">

<div class="p-3">

<h5 class="template-name">

<%=t.getTemplateName()%>

</h5>

<p class="text-muted">

    Danh mục: <%= t.getCategory() %>

</p>

<a
href="${pageContext.request.contextPath}/editor?template=<%=t.getTemplateID()%>"
class="btn btn-use">

Sử dụng

</a>

</div>

</div>

</div>

<%
}
}
%>

</div>

</div>

<script src="${pageContext.request.contextPath}/assets/js/template.js"></script>

</body>

</html>