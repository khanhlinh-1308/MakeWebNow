<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="entity.Template"%>

<%
Template template = (Template) request.getAttribute("template");
%>

<!DOCTYPE html>
<html lang="vi">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Editor | Make Web Now</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/editor.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>

<body>

<input type="hidden"

       id="websiteID"

       value="1">

<!-- Toolbar -->

<div class="toolbar">

    <div class="logo">
         Make Web Now
    </div>

    <div>
<a href="#" id="btnDashboard"

   class="btn btn-outline-secondary">

    <i class="fa-solid fa-arrow-left"></i>

    Dashboard

</a>
        <button class="btn btn-save" id="btnSave">
            <i class="fa-solid fa-floppy-disk"></i>
            Lưu
        </button>

        <button class="btn btn-preview">
            <i class="fa-solid fa-eye"></i>
            Preview
        </button>

        <button class="btn btn-download">
            <i class="fa-solid fa-download"></i>
            Tải về
        </button>

        <button class="btn btn-ai">
             AI Layout
        </button>

        <a href="${pageContext.request.contextPath}/logout"
           class="btn btn-danger">

            Đăng xuất

        </a>

    </div>

</div>

<!-- Main -->

<div class="editor-container">

    <!-- LEFT -->

    <div class="sidebar">

        <h5>Blocks</h5>

        <div class="block-item" draggable="true">
            Header
        </div>

        <div class="block-item" draggable="true">
            Text
        </div>

        <div class="block-item" draggable="true">
            Button
        </div>

        <div class="block-item" draggable="true">
            Image
        </div>

        <div class="block-item" draggable="true">
            Footer
        </div>

    </div>

    <!-- CENTER -->

    <div class="canvas">

        <h3>
            <%= template.getTemplateName() %>
        </h3>

        <p class="text-muted">

            Kéo Block vào đây để bắt đầu thiết kế.

        </p>

        <div id="drop-area">

        </div>

    </div>

    <!-- RIGHT -->

    <div class="properties">

        <h5>Thuộc tính</h5>

        <label>Nội dung</label>

        <textarea class="form-control"></textarea>

        <br>

        <label>Màu chữ</label>

        <input type="color"
               class="form-control form-control-color">

        <br>

        <label>Màu nền</label>

        <input type="color"
               class="form-control form-control-color">
		<hr>

<button id="btnDuplicate"
        class="btn btn-primary w-100 mb-2">

    Nhân đôi Block

</button>

<button id="btnDelete"
        class="btn btn-danger w-100 mb-2">

    Xóa Block

</button>

<button id="btnUp"
        class="btn btn-outline-secondary w-100 mb-2">

    Di chuyển lên

</button>

<button id="btnDown"
        class="btn btn-outline-secondary w-100">

    Di chuyển xuống

</button>
        <br>

    </div>

</div>

<script src="${pageContext.request.contextPath}/assets/js/editor.js"></script>

</body>
</html>