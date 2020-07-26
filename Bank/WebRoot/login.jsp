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
	
	<title>银行管理系统</title>
	<link rel="stylesheet" href="res/css/login.css" type="text/css" />
	<link type="text/css" rel="stylesheet" href="res/font/font-awesome.min.css"/>

  <script type="text/javascript">
  window.onload = (function(){
		   var tip = session.getAttribute("tip");
		   alert(tip);
  });
  
  	function validate(){
  		
  		var name =document.getElementById("userNumber");
  		var pas =document.getElementById("password");
  		String pattern = "^[0-9]{6}$";
  		if(name.value==""){
  			alert("用户名不能为空");
  			return false;
  		}else if(pas.value==pattern){
  			alert("密码格式错误");
  			return false;
  		}else{
  			return true;
  			};
  	}
  </script>
  </head>
  
 <body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo"><span>银行管理系统</span></h1>
				<span class="slogan">欢迎使用银行管理系统</span>
            </div><!--logo-->
            
          <br clear="all" /><br />
            
            
            <form id="login" action="LoginServlet" method="post" onsubmit="return validate();">
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" name="userNumber" id="userNumber" placeholder="账户" />
                    </div>
                </div>
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" name="password" id="password" placeholder="密码" />
                    </div>
                </div>
                <button>登录</button> 
            </form>
        </div><!--loginboxinner-->
    </div><!--loginbox-->

</body>
</html>
