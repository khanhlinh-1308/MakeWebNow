<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="vi">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Đăng nhập | Make Web Now</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/login.css">

</head>

<body>

<div class="container-fluid">

    <div class="row vh-100">

        <!-- Left -->

        <div class="col-lg-6 left-panel">

            <div class="logo">

                Make Web Now

            </div>

            <h1>
                Thiết kế Website<br>
                dễ như Scratch.
            </h1>

            <p>
                Tạo website bằng cách kéo thả Block,
                không cần biết lập trình.
            </p>

        </div>

        <!-- Right -->

        <div class="col-lg-6 d-flex justify-content-center align-items-center">

            <div class="login-card">

                <h2>Đăng nhập</h2>

                <p class="text-muted mb-4">
                    Chào mừng quay trở lại.
                </p>

                <% if(request.getAttribute("error") != null){ %>

                <div class="alert alert-danger">

                    <%= request.getAttribute("error") %>

                </div>

                <% } %>

                <form action="${pageContext.request.contextPath}/login"
                      method="post">

                    <div class="mb-3">

                        <label>Email</label>

                        <input
                                type="email"
                                name="email"
                                class="form-control"
                                required>

                    </div>

                    <div class="mb-4">

                        <label>Mật khẩu</label>

                        <input
                                type="password"
                                name="password"
                                class="form-control"
                                required>

                    </div>

                    <button class="btn btn-login">

                        Đăng nhập

                    </button>

                </form>

                <div class="divider">

                    HOẶC

                </div>

                <button class="btn btn-google">

                    Đăng nhập với Google

                </button>

                <div class="bottom-link">

                    Chưa có tài khoản?

                    <a href="${pageContext.request.contextPath}/register">

                        Đăng ký ngay

                    </a>

                </div>

            </div>

        </div>

    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>