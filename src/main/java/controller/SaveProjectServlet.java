package controller;

import java.io.IOException;

import java.util.Date;

import entity.Website;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import service.WebsiteService;

@WebServlet("/saveProject")

public class SaveProjectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WebsiteService websiteService = new WebsiteService();

    @Override

    protected void doPost(HttpServletRequest request,

            HttpServletResponse response)

            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Integer websiteID =

                Integer.parseInt(request.getParameter("websiteID"));

        String content =

                request.getParameter("content");

        Website website =

                websiteService.findById(websiteID);

        website.setWebsiteContent(content);

        website.setLastSaved(new Date());

        websiteService.update(website);

        response.getWriter().print("success");

    }

}
