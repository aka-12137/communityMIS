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

</head>

<body>
<img src="img/login.jpg" class="bgImg">
<div class="content" style="margin-top: 90px">
	<div class="bidTitle" style="margin-top: 30px;">广东工业大学学生会信息管理系统</div>
	<form id="loginForm" action="user_user_regedit.action" method="post"  style="height:360px;">
	<div class="logCon">
		<div style="text-align: center;"><c:if test="${errormessage!=null or errormessage!='' }">
    	<font style="color: #000000;font-weight: 900;font-size: 18px">${errormessage }</font>
    	</c:if></div>
		<div class="line"><span>用户名:</span>
		<input id="username" class="bt_input" type="text" name="user.username" value="${user.username }"/></div>
		<div class="line"><span>&nbsp;&nbsp;&nbsp;密码:</span>
		<input id="password" class="bt_input" type="password" name="user.password" value="${user.password}"/></div>
		<div class="line"><span>&nbsp;&nbsp;&nbsp;姓名:</span>
		<input id="name" class="bt_input" type="text" name="user.name" value="${user.name }"/></div>
		<div class="line" ><span>&nbsp;&nbsp;&nbsp;性别:</span>
			<select style="width:340px;border-radius: 2px;    padding: 11px 5px;    
				margin-right: 20px; border:1px solid #2d8c5fa6;   margin-left: 5px;    margin-bottom: 18px;font-size:18px;" 
				name="user.sex">
				<option value="男" <c:if test="${user.sex=='男' }">selected="selected"</c:if>>男</option>
				
				<option value="女" <c:if test="${user.sex=='女' }">selected="selected"</c:if>>女</option>
			</select>
		</div>
		<div class="line"><span>&nbsp;&nbsp;&nbsp;电话:</span>
		<input id="phone" class="bt_input" type="text" name="user.phone" value="${user.phone }"/></div>
		<button type="submit" class="logingBut" style="font-size: 18px;font-weight: 600;">注册</button>
		<br/><br/>
		已有账户，请
	<a style="color:#ffd400;font-size: 16px;" href="login.jsp">点此登录</a>!
	</div>
	
	</form>
</div>

</body>

</html>