<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>广东工业大学学生会信息管理系统</title>
<link rel="stylesheet" href="login/css/index.css" />
<script type="text/javascript" src="js/libs/index.js"></script>
</head>

<body>
<img src="img/login.jpg" class="bgImg">
<div class="content" style="margin-top: 140px;">
	<div class="bidTitle" style="margin-top: 30px;">广东工业大学学生会信息管理系统</div>
	<form id="loginForm" action="login.action" method="post"  style="height:260px;">
	<div class="logCon">
		<div style="text-align: center;"><c:if test="${errormessage!=null or errormessage!='' }">
    	<font style="color: #ff0000;font-weight: 900;font-size: 18px">${errormessage }</font>
    	</c:if></div>
		<div class="line"><span>用户名:</span>
		<input class="bt_input" type="text" name="username"/></div>
		<div class="line"><span style="margin-right:3px;">&nbsp;&nbsp;&nbsp;密码:</span>
		<input class="bt_input" type="password" name="password" /></div>
		<div class="line" style="margin-right:30px;padding-left:15px;"><span>用户身份:</span>
		<select class="bt_input" style="width:340px;margin-left:3px;">
		<option>管理员</option>
		<option>普通用户</option>
		</select>
		</div>
		<button type="submit" class="logingBut" style="font-size: 18px;font-weight: 600;"onclick="javascript:alert('身份验证成功！')">登录</button>
		<br/><br/>
		若您没有账户，请
	<a style="color:#ffd400;font-size: 16px;" href="regedit.action">点此注册</a>!
	</div>
	
	</form>
</div>

</body>

</html>