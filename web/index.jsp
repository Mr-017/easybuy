<%--
  Created by IntelliJ IDEA.
  Author: XiaoMing
  Date: 2021/7/2
  Time: 9:09
  Come on, boy
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<%
    Object obj=request.getAttribute("productCategoryVoList");
    if(obj==null){
        response.sendRedirect(request.getContextPath()+"/Home?action=index");
    }
%>

This is my JSP page. <br>
</body>
</html>