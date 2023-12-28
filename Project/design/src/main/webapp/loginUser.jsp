<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link id="css" rel="stylesheet" type="text/css" href="./css/index.css" />
</head>

<body
	style="background: url(./imgs/cleaner.png); background-size: 100% 100%; background-attachment: fixed">
	<h1
		style="text-align: center; font-size: 40px; padding-top: 1px; font-weight: 700; color: #000000; text-shadow: 2px 3px #FFFFFF;">红十字社团管理系统</h1>
	<div class="loginDiv" id="loginDiv">
		<form action="loginServlet" method="post" id="form">
			<h1 id="loginMsg">登录</h1>
			<div id="errorMsg">${login_msg}${register_msg}</div>
			<p>
				社员账号:<input id="username" name="username" type="text"
					value="${cookie.username.value}">
			</p>
			<p>
				社员密码:<input id="password" name="password" type="password"
					value="${cookie.password.value}">
			</p>
			<p>
				记住账号密码:<input id="remember" name="remember" type="checkbox"
					value="1">
			</p>
			<p>
				<input type="hidden" id="loginType" name="loginType" value="user">
			</p>
			<div id="subDiv">
				<input type="submit" class="button" value="登录"> <input
					type="reset" class="button" value="重置"> <a
					href="register.jsp">点击注册</a>
			</div>
			<div id="changeDiv">
				<a href="loginAdmin.jsp">管理员登录</a>
				<a href="loginRole.jsp">负责人登录</a>
			</div>
		</form>
	</div>
</body>
</html>