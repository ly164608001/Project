<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
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
    		$(function(){
    			$("#button").click(function(){
    				if($("#jdbcType").val()==""){
						$.messager.alert('错误提示','请选择数据库类型!');
						return;    				
    				}
    				if($("#jdbcUrl").val()==""){
						$.messager.alert('错误提示','请填写数据库Url!');
						return;    				
    				}
    				if($("#user").val()==""){
						$.messager.alert('错误提示','请填写数据库用户名!');
						return;    				
    				}
    				if($("#password").val()==""){
						$.messager.alert('错误提示','请填写数据库密码!');
						return;    				
    				}
    				$("#button").attr("disabled",true);
    				$.ajax({
    					url:"${basePath}userJson/createCode",
    					type:"POST",
    					data:{jdbcType:$("#jdbcType").val(),jdbcUrl:$("#jdbcUrl").val(),user:$("#user").val(),password:$("#password").val(),tableName:$("#tableName").val()},
    					dataType:"text",
    					success:function(data){
    						$("#button").attr("disabled",false);
    						if(data == "success"){
    							$.messager.show({
									title:'提示',
									msg:'代码生成成功!',
									timeout:5000,
									showType:'slide'
								});
    						}else{
    							$.messager.alert('错误提示','代码生成失败，'+data);
    						}
    					}
    				});
    				
    			});
    		})
    </script>
    <title>数据库信息选择</title>
  </head>
  
  <body>
  	<div style="margin:20px">
  		数据库类型选择：
  		<select id="jdbcType" style="margin-left:20px;height:28px">
  			<option value="">请选择
  			<option value="mysql">mysql
  			<option value="oracle">oracle
  			<option value="sqlServer">sqlServer
  		</select>
  		<br/>
  		<br/>
  		数据库Url填写：<input id="jdbcUrl" style="margin-left:35px;"/>
  		<br/>
  		<br/>
  		数据库用户名填写：<input id="user" style="margin-left:10px;"/>
  		<br/>
  		<br/>
  		数据库密码填写：<input id="password" style="margin-left:25px;"/>
  		<br/>
  		<br/>
  		数据库表名：<input id="tableName" style="margin-left:53px;"/>
  		<br/>
  		<br/>
  		<button id="button">代码生成</button>
  	</div>
  </body>
</html>
