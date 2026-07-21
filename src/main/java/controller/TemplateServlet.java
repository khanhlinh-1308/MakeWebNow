package controller;

import java.io.IOException;

import java.util.List;

import dao.TemplateDAO;

import entity.Template;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/template")

public class TemplateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TemplateDAO templateDAO = new TemplateDAO();

    @Override

    protected void doGet(HttpServletRequest request,

            HttpServletResponse response)

            throws ServletException, IOException {

        List<Template> templates = templateDAO.findAll();

        request.setAttribute("templates", templates);

        request.getRequestDispatcher("/views/user/templates.jsp")

                .forward(request, response);

    }

}
