<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html ng-app="userApp">
  <head>
  	<!-- $http.get('<%=basePath%>/userJson/getAllUser').success(function (data) {
			     $scope.users= data;
			}); -->
    <base href="<%=basePath%>">
    <jsp:include page="/baseJsp/baseJsp.jsp"></jsp:include>
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <title>用户列表</title>
    <script>
    	var userApp = angular.module("userApp",[]);
    	userApp.controller("userCtrl",function($scope,$http){
				$http.get('<%=basePath%>/userJson/getAllUser').success(function (data) {
			     $scope.users= data;
				});
    	});
    </script>
  </head>
  
  <body>
    <h6><a href="<%=basePath%>user/toAddUser">用户列表</a></h6>
    <table class="table table-striped" ng-controller="userCtrl">
    	<thead>
    		<th>用户名</th>
    		<th>年龄</th>
    	</thead>
    	<tbody>
	    	<tr ng-repeat="user in users">
	    		<td>{{user.userName}}</td>
	    		<td>{{user.age}}</td>
	    	</tr>
    	</tbody>
    </table>
  </body>
</html>
