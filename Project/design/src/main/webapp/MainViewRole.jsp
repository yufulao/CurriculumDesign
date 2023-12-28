<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交活动表单</title>
<link id="css" rel="stylesheet" type="text/css" href="./css/index.css"/>
</head>
<body style="background: url(./imgs/cleaner.png);background-size:100% 100% ; background-attachment: fixed ">
	<div  class="roleApplyDiv">
	<br>
		<form id="regist-form" action="roleApplyServlet" method="post">
			<table>
				<tr>
					<td>活动名称</td>
					<td class="inputs"><input name="activityName" type="text"
						id="activityName"><br> <span id="activityName_err"
						class="err_msg" style="display: none">活动名已存在</span></td>
				</tr>
				<tr>
					<td>开始时间</td>
					<td class="inputs"><input name="startTime" type="text"
						id="startTime"><br> <span id="startTime_err"
						class="err_msg">${startTime_msg}</span></td>
				</tr>
				<tr>
					<td>结束时间</td>
					<td class="inputs"><input name="endTime" type="text"
						id="endTime"><br> <span id="endTime_err"
						class="err_msg">${endTime_msg}</span></td>
				</tr>
				<tr>
					<td>人数上限</td>
					<td class="inputs"><input name="peopleCountMax" type="text"
						id="peopleCountMax"><br> <span id="peopleCountMax_err"
						class="err_msg">${peopleCountMax_msg}</span></td>
				</tr>
				<tr>
					<td>活动场地</td>
					<td class="inputs"><input name="requirement" type="text"
						id="requirement"><br> <span id="requirement_err"
						class="err_msg">${requirement_msg}</span></td>
				</tr>
				<tr>
					<td>活动简介</td>
					<td class="inputs"><input name="activityIntroduction" type="text"
						id="activityIntroduction"><br> <span id="activityIntroduction_err"
						class="err_msg">${activityIntroduction_msg}</span></td>
				</tr>
			</table>

			<div class="buttons">
				<input value="提交" type="submit" id="reg_btn">
			</div>
			<br class="clear">
		</form>
	</div>
	<script>
		//给用户名绑定失去焦点的事件
		document.getElementById("activityName").onblur = function() {
			//获取用户名的值
			var activityName = this.value;

			//发送ajax请求
			var httpRequest;
			httpRequest = new XMLHttpRequest();
			httpRequest.open("GET",
					"http://localhost:8080/design/ajaxRoleApplyServlet?activityName="
							+ activityName);
			httpRequest.send();
			//获取响应
			httpRequest.onreadystatechange = function alertContents() {
				if (this.readyState === 4) {
					if (httpRequest.status === 200) {
						if (this.responseText == "true") {
							//用户名存在，显示提示信息
							document.getElementById("activityName_err").style.display = '';
						} else {
							//用户名不存在，关闭提示信息
							document.getElementById("activityName_err").style.display = 'none';
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