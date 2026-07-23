package controller;

import java.io.IOException;
import java.util.List;

import dao.WebsiteDAO;
import entity.User;
import entity.Website;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WebsiteDAO websiteDAO = new WebsiteDAO();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user != null) {

            List<Website> websites =
                    websiteDAO.findByUser(user);

            request.setAttribute("websites", websites);
        }

        request.getRequestDispatcher("/views/user/dashboard.jsp")
                .forward(request, response);

    }

}