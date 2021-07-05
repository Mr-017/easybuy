package com.hisoft.easybuy.controller;


import com.alibaba.fastjson.JSON;
import com.hisoft.easybuy.javabeen.entity.User;
import com.hisoft.easybuy.service.Impl.UserServiceImpl;
import com.hisoft.easybuy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = ("/Login"))
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if ("toLogin".equals(action)){
            request.getRequestDispatcher("pre/login.jsp").forward(request, response);
        }else if ("login".equals(action)){
            String name = request.getParameter("loginName");
            String pwd = request.getParameter("password");
            UserService userService = new UserServiceImpl();
            User user = userService.login(name, pwd);

            if (user == null) {
                out.print(JSON.toJSONString("登录失败"));
            } else {
                out.print(JSON.toJSONString(user));
//                    out.print("<script type='text/javaScript'>\n" + "alert('登录成功！')"+ "</script>");
            }

        }

    }
}
