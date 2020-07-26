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
    <title>查询月账单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link type="text/css" rel="stylesheet" href="res/css/H-ui.css"/>
	<link type="text/css" rel="stylesheet" href="res/css/H-ui.admin.css"/>
	<link type="text/css" rel="stylesheet" href="res/font/font-awesome.min.css"/>
	
<script type="text/javascript">
	function submitLogin(){
		var login = document.getElementById('login').value; 
		
		location.href="userSelectServlet?login="+login;
	}
	function dataDelete(){
		layer.confirm('确认要删除吗？',function(index){
		 var el = document.getElementsByTagName("input");  
		 var len = el.length;  
		 for(var i=0; i <len; i++)      
	      {          
			 if((el[i].type=="checkbox")){
				 if(el[i].checked&&el[i].value!=""){
				 
				     $.post("baseDeleteServlet",{userId:el[i].value});
				 }
			 }
	      }
		 layer.msg('已删除!请刷新页面',1);
		});
	}
</script>
  </head>
  
  <body>
   <%
		String moneySumIn = (String)session.getAttribute("moneySumIn");
		String moneySumOut = (String)session.getAttribute("moneySumOut");
  %>
<nav class="Hui-breadcrumb">
  <i class="icon-home"></i> 
     首页 
  <span class="c-gray en">&gt;</span>
     查询月账单
  <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
     <i class="icon-refresh"></i>
  </a>
</nav>
  
  <table class="table table-border table-bordered table-hover table-bg table-sort" id="table">
    <thead >
        <tr>
          <th colspan="2"><font size= '3' family='楷体'>月账单</font></th>
        </tr>
      </thead>
    <thead>
      <tr class="text-c">
        <th width="100"><font size="4" family='楷体'> 操作类型</font></th>
        <th width="100"><font size="4" family='楷体'> 操作金额</font></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th class="text-c"><font size="4" family='楷体'> 收入</font></th>
        <td class="text-c"><font size="4" family='楷体'><%=moneySumIn%></font></td>
      </tr>
    </tbody>
    <tbody>
      <tr>
        <th class="text-c"><font size="4" family='楷体'> 支出</font></th>
        <td class="text-c"><font size="4" family='楷体'><%=moneySumOut%></font></td>
      </tr>
    </tbody>
  </table>
   
</div>

<script type="text/javascript" src="res/js/jquery.min.js"></script> 
<script type="text/javascript" src="res/layer/layer.min.js"></script> 
<script type="text/javascript" src="res/js/pagenav.cn.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/plugin/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="res/js/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script> 

  </body>
</html>
