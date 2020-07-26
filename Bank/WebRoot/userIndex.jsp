<%@page import="cn.bank.entity.Customer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>银行管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="Bookmark" href="/favicon.ico" >
	<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>-->
<script type="text/javascript" src="res/js/html5.js"></script>
<script type="text/javascript" src="res/js/respond.min.js"></script>
<script type="text/javascript" src="res/js/PIE_IE678.js"></script>
<!--[endif]  -->
<link href="res/css/H-ui.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/font/font-awesome.min.css" rel="stylesheet"  type="text/css" />

  </head>
  
  <body style="overflow:hidden">
  
  <%
		Customer cust = (Customer)session.getAttribute("current_user");
  %>
  
<header class="Hui-header cl"> 
   <a class="Hui-logo l" href="/">银行管理系统</a> 
   <a class="Hui-logo-m l" href="/" >银行管理系统</a> 
   <span class="Hui-subtitle l">V2.1</span>
   <span class="Hui-userbox">
      <span class="c-white">当前用户：<%=cust.getCustName() %></span> 
      <a class="btn btn-out radius ml-10" href="#" title="退出"><i class="icon-off"></i>退出</a>
   </span> 
   <a aria-hidden="false" class="Hui-nav-toggle" id="nav-toggle" href="#"></a>
</header>
<div class="cl Hui-main">
  <aside class="Hui-aside" style="">
    <input runat="server" id="divScrollValue" type="hidden" value="" />
    <div class="menu_dropdown bk_2">
      <dl id="menu-user">
        <dt><a _href="BaseServlet?mis=<%=cust.getCustNumber() %>">
        <i class="icon-user"></i> 存款<b></b></a></dt>
      </dl>
      <dl id="menu-comments">
        <dt><a _href="BaseServlet?mos=<%=cust.getCustNumber() %>" href="javascript:;">
        <i class="icon-comments"></i> 取款<b></b></a></dt>
      </dl>
      <dl id="menu-article">
        <dt><a _href="BaseServlet?tms=<%=cust.getCustNumber() %>" href="javascript:void(0)">
        <i class="icon-edit"></i> 转账<b></b></a></dt>
      </dl>
      <dl id="menu-article">
        <dt><a _href="queryMoneyServlet?qms=<%=cust.getCustNumber() %>" href="javascript:void(0)">
        <i class="icon-edit"></i> 查询余额<b></b></a></dt>
      </dl>
      <dl id="menu-article">
        <dt><a _href="BaseServlet?gbs=<%=cust.getCustNumber() %>" href="javascript:void(0)">
        <i class="icon-edit"></i> 月账单<b></b></a></dt>
      </dl>
      
      <dl id="menu-product">
        <dt><a href="#" href="javascript:void(0)">
        <i class="icon-beaker"></i> 切换用户<b></b></a></dt>
      </dl>
   
      <dl id="menu-admin">
        <dt><a _href="BaseServlet?cps=<%=cust.getCustNumber() %>" href="javascript:void(0)"><i class="icon-key">
        </i> 修改密码<b></b></a></dt>
        
      </dl>
      <dl id="menu-system">
        <dt><a href="#" href="javascript:void(0)"><i class="icon-cogs">
        </i> 退出系统<b></b></a></dt>
      </dl>
    </div>	
  </aside>
  <div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);"></a></div>
  <section class="Hui-article">
    <div id="Hui-tabNav" class="Hui-tabNav">
      <div class="Hui-tabNav-wp">
        <ul id="min_title_list" class="acrossTab cl">
          <li class="active"><span title="我的桌面" data-href="welcome.jsp">我的桌面</span><em></em></li>
        </ul>
      </div>
      <div class="Hui-tabNav-more btn-group">
        <a id="js-tabNav-prev" class="btn radius btn-default btn-small" href="javascript:;">
          <i class="icon-step-backward"></i>
        </a>
        <a id="js-tabNav-next" class="btn radius btn-default btn-small" href="javascript:;">
          <i class="icon-step-forward"></i>
        </a>
      </div>
    </div>
    <div id="iframe_box" class="Hui-articlebox">
      <div class="show_iframe">
        <div style="display:none" class="loading"></div>
        <iframe scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
      </div>
    </div>
  </section>
</div>
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/Validform_v5.3.2_min.js"></script> 
<script type="text/javascript" src="res/layer/layer.min.js"></script>
<script type="text/javascript" src="res/js/H-ui.js"></script>
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>

</body>
</html>
