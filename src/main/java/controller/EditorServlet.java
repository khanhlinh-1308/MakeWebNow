package controller;

import java.io.IOException;

import dao.TemplateDAO;

import entity.Template;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editor")

public class EditorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TemplateDAO templateDAO = new TemplateDAO();

    @Override

    protected void doGet(HttpServletRequest request,

            HttpServletResponse response)

            throws ServletException, IOException {

        String id = request.getParameter("template");

        if(id == null){

            response.sendRedirect(request.getContextPath()+"/template");

            return;

        }

        Template template = templateDAO.findById(Integer.parseInt(id));

        request.setAttribute("template", template);

        request.getRequestDispatcher("/views/editor/editor.jsp")

               .forward(request,response);

    }

}
