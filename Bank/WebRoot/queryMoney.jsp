<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询余额</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link type="text/css" rel="stylesheet" href="res/css/H-ui.css"/>
	<link type="text/css" rel="stylesheet" href="res/css/H-ui.admin.css"/>
	<link type="text/css" rel="stylesheet" href="res/font/font-awesome.min.css"/>
	
	<script type="text/javascript" src="res/js/jquery.min.js"></script> 
	<script type="text/javascript" src="res/js/H-ui.js"></script> 
	<script type="text/javascript" src="res/js/H-ui.admin.js"></script> 
	<style>
	body{ min-height:200px; font-size:14px;}
	td,th{ font-size:14px;}
	</style>
	
  </head>
  
  <body>
    <div class="pd-20">
  	<table class="table table-border table-bordered table-bg">
      	<thead>
        <tr>
          <th colspan="2"><font size='4'>查询当前用户余额</font></th>
        </tr>
      </thead>
    <tbody>
    <%
		double money = (Double)session.getAttribute("queryMoney");
	%>
	
         <tr>
            <th width="200" class="text-r"><span class="c-red">*</span><font size='3'> 当前账户总额为：</font></th>
            <td width="300"><font size='3'><%=money %></font></td>
         </tr>
      
    </tbody>
  </table>
</div>
	<!-- <input type="button" value="返回" onclick="window.location.href='userServlet';" 
	style= "height:50px;width:120px "/> -->
  </body>
</html>
