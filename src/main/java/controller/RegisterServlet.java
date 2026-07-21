package controller;

import java.io.IOException;

import dao.SubscriptionDAO;

import dao.RoleDAO;

import dao.UserDAO;

import entity.Role;

import entity.Subscription;

import entity.User;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDAO userDAO = new UserDAO();

    private RoleDAO roleDAO = new RoleDAO();
    
    private SubscriptionDAO subscriptionDAO = new SubscriptionDAO();

    @Override

    protected void doGet(HttpServletRequest request,

            HttpServletResponse response)

            throws ServletException, IOException {

        request.getRequestDispatcher("/views/auth/register.jsp")

                .forward(request, response);

    }

    @Override

    protected void doPost(HttpServletRequest request,

            HttpServletResponse response)

            throws ServletException, IOException {

        String fullName = request.getParameter("fullName");

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        // Kiểm tra email đã tồn tại

        if (userDAO.findByEmail(email) != null) {

            request.setAttribute("error",

                    "Email đã tồn tại!");

            request.getRequestDispatcher("/views/auth/register.jsp")

                    .forward(request, response);

            return;

        }

        User user = new User();

        user.setFullName(fullName);

        user.setEmail(email);

        user.setPassword(password);

        // Role mặc định là Customer

        Role role = roleDAO.findByName("USER");

        user.setRole(role);

        // Chưa nâng cấp tài khoản

        Subscription free = subscriptionDAO.findById(1);

        user.setSubscription(free);

        userDAO.create(user);

        response.sendRedirect(request.getContextPath() + "/login");

    }

}
