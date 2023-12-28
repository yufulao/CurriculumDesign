<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link id="css" rel="stylesheet" type="text/css" href="./css/index.css"/>
</head>
<body style="background: url(./imgs/cleaner.png);background-size:100% 100% ; background-attachment: fixed ">
	<div  class="registDiv">
	<br>
		<a href="loginUser.jsp">返回登录界面</a>
		<form id="regist-form" action="registerServlet" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td class="inputs"><input name="username" type="text"
						id="username"><br> <span id="username_err"
						class="err_msg" style="display: none">用户名已存在</span></td>
				</tr>
				<tr>
					<td>密码</td>
					<td class="inputs"><input name="password" type="text"
						id="password"><br> <span id="password_err"
						class="err_msg">${password_msg}</span></td>
				</tr>
				<tr>
					<td>学号</td>
					<td class="inputs"><input name="userSid" type="text"
						id="userSid"><br> <span id="userSid_err"
						class="err_msg">${userSid_msg}</span></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td class="inputs"><input name="userEmail" type="text"
						id="userEmail"><br> <span id="userEmail_err"
						class="err_msg">${userEmail_msg}</span></td>
				</tr>
				<tr>
					<td>电话</td>
					<td class="inputs"><input name="userTel" type="text"
						id="userTel"><br> <span id="userTel_err"
						class="err_msg">${userTel_msg}</span></td>
				</tr>
				<tr>
					<td>身份证号码</td>
					<td class="inputs"><input name="userIdentityCard" type="text"
						id="userIdentityCard"><br> <span id="userIdentityCard_err"
						class="err_msg">${userIdentityCard_msg}</span></td>
				</tr>
				<tr>
					<td>个人简介</td>
					<td class="inputs"><input name="userIntroduction" type="text"
						id="userIntroduction"><br> <span id="userIntroduction_err"
						class="err_msg">${userIntroduction_msg}</span></td>
				</tr>
			</table>

			<div class="buttons">
				<input value="注册" type="submit" id="reg_btn">
			</div>
			<br class="clear">
		</form>
	</div>
	<script>
		//给用户名绑定失去焦点的事件
		document.getElementById("username").onblur = function() {
			//获取用户名的值
			var username = this.value;

			//发送ajax请求
			var httpRequest;
			httpRequest = new XMLHttpRequest();
			httpRequest.open("GET",
					"http://localhost:8080/design/ajaxRegistServlet?username="
							+ username);
			httpRequest.send();
			//获取响应
			httpRequest.onreadystatechange = function alertContents() {
				if (this.readyState === 4) {
					if (httpRequest.status === 200) {
						if (this.responseText == "true") {
							//用户名存在，显示提示信息
							document.getElementById("username_err").style.display = '';
						} else {
							//用户名不存在，关闭提示信息
							document.getElementById("username_err").style.display = 'none';
						}
					} else {
						alert("请求遇到了问题。");
					}
				}
			}
		}
	</script>
</body>
</html>