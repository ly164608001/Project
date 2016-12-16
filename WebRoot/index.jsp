<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:include page='${basePath}/baseJsp/baseJsp.jsp'/>
    <!--  <script type="text/javascript" src="${basePath}js/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${basePath}js/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="${basePath}css/easyui.css"/>
	<link rel="stylesheet" href="${basePath}css/icon.css"/> -->
    <script type="text/javascript">
    		function register(){
    			if($("#userName").val().trim()==""){
    				alert("用户名不能为空！");
    				return;
    			}
    			if($("#password").val().trim()==""){
    				alert("密码不能为空！");
    				return;
    			}
    			if($("#email").val().trim()==""){
    				alert("邮箱不能为空！");
    				return;
    			}
    			$.ajax({
    				url:"user/addUser",
    				type:"post",
    				data:{userName:$("#userName").val(),password:$("#password").val(),email:$("#email").val()},
    				success:function(data){
    					alert("注册成功,用户信息已经发至你邮箱！");
    				}
    			});
    		}
    </script>
    <title>首页</title>
  </head>
  
  <body style="background-color: #2aabd2">
    <div class="container" style="margin-left: 400px;margin-top: 200px">
        <form class="form-horizontal" role="form" action="<%=basePath%>user/getAllUser" method="post">
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="userName" name="userName"
                           placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="password" name="password"
                           placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="email" name="email"
                           placeholder="注册需填入邮箱">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> 请记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">登录</button>
                    <button type="reset" class="btn btn-danger" style="margin-left: 15px">重置</button>
                    <button type="button" class="btn btn-primary"style="margin-left: 15px" onclick="register();">注册</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
