package filter;

import java.io.IOException;

import entity.User;

import jakarta.servlet.Filter;

import jakarta.servlet.FilterChain;

import jakarta.servlet.FilterConfig;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.http.HttpFilter;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {

        "/dashboard",

        "/template",

        "/editor",

        "/payment",

        "/premium"

})

public class AuthFilter extends HttpFilter implements Filter {

    private static final long serialVersionUID = 1L;

    @Override

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override

    public void doFilter(HttpServletRequest request,

                         HttpServletResponse response,

                         FilterChain chain)

            throws IOException, ServletException {

        HttpSession session = request.getSession(false);

        User user = null;

        if (session != null) {

            user = (User) session.getAttribute("user");

        }

        if (user == null) {

            response.sendRedirect(

                    request.getContextPath() + "/login");

            return;

        }

        chain.doFilter(request, response);

    }

}
