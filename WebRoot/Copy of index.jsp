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
  
  <body>
  	<div class="easyui-dialog" title="首页" data-options="iconCls:'icon-save'" style="width:500px;height:300px;background:url(img/bg.png);background-size:100 80;">
         <h1 align="center">用户管理系统</h1> 
         <div class="easyui-panel" style="width:300px,padding:100px" align="center">
         	<form action="<%=basePath%>user/getAllUser" method="post">
         		<table cellpadding="5">
         			<tr>
         				<td>用户名：</td>
         				<td>
         					<input class="easyui-textbox" data-options="required:true" type="text" name="userName" id="userName">
         				</td>
         			</tr>
         			<tr>
         				<td>&nbsp;&nbsp;密码：</td>
         				<td>
         					<input class="easyui-textbox" data-options="required:true" type="password" name="password" id="password">
         				</td>
         			</tr>
         			<tr>
         				<td>&nbsp;&nbsp;邮箱：</td>
         				<td>
         					<input class="easyui-textbox" type="text" name="email" id="email">
         				</td>
         			</tr>
         			<tr>
         				<td colspan="3" style="color:red;">
         					<div id="errorMsg"></div>
         				</td>
         			</tr>
         			<tr>
         				<td>
         					<button class="easyui-linkbutton" type="submit" text="登录" style="width:75px" ></button>
         				</td>
         				<td>
         					<button class="easyui-linkbutton" type="reset" text="重置" style="width:75px"></button>
         					<button class="easyui-linkbutton" type="button" text="注册" style="width:75px" onclick="register();"></button>
         				</td>
         			</tr>
         		</table>
         	</form>
         </div>
     </div>
  </body>
</html>
