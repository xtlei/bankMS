<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<title>图书管理系统</title>
	<link rel="stylesheet" href="res/css/login.css" type="text/css" />
	<link type="text/css" rel="stylesheet" href="res/font/font-awesome.min.css"/>

  </head>
  
 <body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo"><span>银行管理系统</span></h1>
				<span class="slogan">欢迎使用银行管理系统</span>
            </div><!--logo--><br /><br /><br />
            <p align="center"><font size="4" color="red">登录失败！</font></p>
            <p align="center"><font size="4" color="red">请检查用户名或密码!</font></p>
          <br clear="all" /><br /><br />
          <div align="center"><input type="button" value="返回登入页面" onclick="window.location.href='login.jsp';" ></div><br />
        </div><!--loginboxinner-->
    </div><!--loginbox-->

</body>
</html>
