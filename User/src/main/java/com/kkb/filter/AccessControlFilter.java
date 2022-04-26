package com.kkb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessControlFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String loginName = (String) request.getSession().getAttribute("user");
        if(loginName != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/phone/login.html");
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
