<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询月账单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="res/css/H-ui.css"/>
	<link type="text/css" rel="stylesheet" href="res/css/H-ui.admin.css"/>
	<link type="text/css" rel="stylesheet" href="res/font/font-awesome.min.css"/>
  </head>
  
  <body>
   <%
		String gbs = (String)session.getAttribute("custNumber3");
  %>
<div class="pd-20">
  <form class="Huiform" id="loginform" action="GetBillServlet?gbs=<%=gbs %>" method="post">
    <table class="table table-border table-bordered table-bg">
      <thead >
        <tr>
          <th colspan="2"><font size= '4'>查询月账单</font></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th class="text-r"><font size= '3'>输入查询年月份：</font></th>
          <td ><input name="queryDate" id="queryDate" class="input-text" type="text" autocomplete="off" placeholder="输入年月份" tabindex="2" nullmsg="请输入要查询的年月份！" > 
          </td>
        </tr>
        
        <tr>
          <th></th>
          <td>
            <button type="submit" class="btn btn-success radius" id="admin-password-save" name="admin-password-save"><i class="icon-ok"></i> 确定</button>
          </td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/Validform_v5.3.2_min.js"></script> 
<script type="text/javascript" src="res/layer/layer.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(".Huiform").Validform(); 
</script>

</body>
</html>
