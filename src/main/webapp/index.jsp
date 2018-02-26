<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
				<!-- shiro的用户  -->
	<h1>hello-- <shiro:principal></shiro:principal></h1>
	<!-- 当没有用户登录时显示 -->
	<shiro:guest>
		<a href="/login">登录页面</a>
	</shiro:guest>
	<shiro:user>
		<!-- 拥有用户add权限的显示内容 -->
		<shiro:hasPermission name="user:add">
			<a href="/user/add.jsp">用户添加</a>
		</shiro:hasPermission>
		<shiro:hasRole name="admin">
			<a href="/admin/index.jsp">用户管理</a>
		</shiro:hasRole>
		<a href="/user/list.jsp">用户列表</a>
		<a href="/logout">用户退出</a>
	</shiro:user>
</body>
</html>