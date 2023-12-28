<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活动录入审核界面</title>
<link id="css" rel="stylesheet" type="text/css" href="./css/index.css" />
</head>
<body
	style="background: url(./imgs/cleaner.png); background-size: 100% 100%; background-attachment: fixed">
	
	<!-- el表达式 -->
	<h1
		style="text-align: center; font-size: 40px; padding-top: 1px; font-weight: 700; color: #000000; text-shadow: 2px 3px #FFFFFF;">${user.adminName}，欢迎进入活动录入审核界面</h1>
	<hr>
	<table class="gameDiv" border="1" cellspacing="0" width="800">
		<tr>
			<th>活动名称</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>人数上限</th>
			<th>活动场地</th>
			<th>活动简介</th>
			<th>操作</th>
		</tr>

		<!-- jstl标签 -->
		<c:forEach items="${activities}" var="activity">
			<tr align="center">
				<td>${activity.activityName}</td>
				<td>${activity.startTime}</td>
				<td>${activity.endTime}</td>
				<td>${activity.peopleCountMax}</td>
				<td>${activity.requirement}</td>
				<td>${activity.activityIntroduction}</td>
				<td>
					<button type="button" class="button" id="submitButton" onclick="luru('${activity.activityName}')">录入</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:out value="当前未录入的活动已全部展示" default="当前未录入的活动已全部展示" escapeXml="true"></c:out>
	
	<script>
	function luru(activityName) {
    	var httpRequest;
		httpRequest = new XMLHttpRequest();
		httpRequest.open("GET",
			"http://localhost:8080/design/ajaxPassActivityServlet?activityName="
					+ encodeURIComponent(activityName));
		httpRequest.send();
	
		//获取响应
		httpRequest.onreadystatechange = function alertContents() {
			if (this.readyState === 4) {
				if (httpRequest.status === 200) {
					window.location.href = window.location.href;//立刻刷新当前页面
				} else {
				alert("请求遇到了问题。");
				}
			}
		}
	}
</script>
</body>
</html>