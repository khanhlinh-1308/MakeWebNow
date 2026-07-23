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

    <div class="d-flex align-items-center">

        <button id="btnDashboard"
                class="btn btn-home"
                title="Trang chủ">

            <i class="fa-solid fa-house"></i>

        </button>

        <div class="logo ms-3">

            <i class="fa-solid fa-code"></i>

            Make Web Now

        </div>
		<span id="saveStatus"
      class="ms-3 text-muted">

Chưa lưu

</span>
    </div>

    <div>
<button id="btnUndo"
        class="btn btn-outline-secondary">

    <i class="fa-solid fa-rotate-left"></i>

</button>

<button id="btnRedo"
        class="btn btn-outline-secondary">

    <i class="fa-solid fa-rotate-right"></i>

</button>
        <button class="btn btn-save" id="btnSave">

            <i class="fa-solid fa-floppy-disk"></i>

            Lưu

        </button>

        <div class="btn-group">

    <button class="btn btn-preview"
            id="btnPreviewDesktop">

        <i class="fa-solid fa-desktop"></i>

    </button>

    <button class="btn btn-preview"
            id="btnPreviewTablet">

        <i class="fa-solid fa-tablet-screen-button"></i>

    </button>

    <button class="btn btn-preview"
            id="btnPreviewMobile">

        <i class="fa-solid fa-mobile-screen-button"></i>

    </button>

</div>

        <button class="btn btn-download">

            <i class="fa-solid fa-download"></i>

            Download

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

    <h5 class="sidebar-title">

        <i class="fa-solid fa-cubes"></i>

        Blocks

    </h5>

    <div class="block-category">

        Basic

    </div>

    <div class="block-item" draggable="true">

        <i class="fa-solid fa-heading"></i>

        Header

    </div>

    <div class="block-item" draggable="true">

        <i class="fa-solid fa-align-left"></i>

        Text

    </div>

    <div class="block-item" draggable="true">

        <i class="fa-solid fa-square"></i>

        Button

    </div>

    <div class="block-item" draggable="true">

        <i class="fa-regular fa-image"></i>

        Image

    </div>

    <div class="block-item" draggable="true">

        <i class="fa-solid fa-window-maximize"></i>

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