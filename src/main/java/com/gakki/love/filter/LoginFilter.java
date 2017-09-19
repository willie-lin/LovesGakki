package com.gakki.love.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/16
 * \* Time: 1:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (httpServletRequest.getSession().getAttribute("user") == null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user");
        }else {
            chain.doFilter(request,response);

    }}

    @Override
    public void destroy() {

    }
}