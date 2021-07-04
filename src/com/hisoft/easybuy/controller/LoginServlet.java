package com.hisoft.easybuy.controller;


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

            String uname = request.getParameter("loginName");
            String upwd = request.getParameter("password");
            if (uname == null || "".equals(uname)) {
                request.setAttribute("error", "用户名不能为空");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (upwd == null || "".equals(upwd)) {
                request.setAttribute("error", "密码不能为空");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                //        NewsUserDao userDao = new NewsUserDaoImpl();
                UserService userService = new UserServiceImpl();
                User user = userService.login(uname, upwd);

                if (user == null) {
                    request.setAttribute("error", "用户名或密码错误，请重新登录");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    Cookie c = new Cookie("login", "login");
                    c.setMaxAge(5 * 60);
                    response.addCookie(c);
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(20 * 60);
                    session.setAttribute("user", uname);
//                out.print("登录成功");
                    out.print("<script type=\"text/javaScript\">\n" +
                            "                        alert(\"登录成功！\");\n" /*+
                        "                location.href = \"news?action=backnews\";\n" */+
                            "</script>");
                    out.print("<script language='javascript'>location.href='/index.jsp'</script>");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            }
        }



    }
}
