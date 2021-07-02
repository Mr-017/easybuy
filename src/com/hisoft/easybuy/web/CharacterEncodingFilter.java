package com.hisoft.easybuy.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    private String charset;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        System.out.println("请求过来了");
        chain.doFilter(request,response);
        System.out.println("响应通过过滤器");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset = filterConfig.getInitParameter("charset");
        System.out.println("init----------");
    }

    @Override
    public void destroy() {
        System.out.println("destroy---------");
    }

}