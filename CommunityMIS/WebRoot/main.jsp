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
		<meta charset="utf-8" />
		<title>广东工业大学学生会信息管理系统</title>
		<link href="new/css/Site.css" rel="stylesheet" type="text/css" />
		<link href="new/css/zy.layout.css" rel="stylesheet" />
		<link href="new/css/zy.form.css" rel="stylesheet" />
		<link href="new/css/font-awesome.min.css" rel="stylesheet" />
		<link href="css/main.css" rel="stylesheet" />
		<style type="text/css">
			.headerlitooleulsubitem_gray {
				background-Color: White;
				position: absolute;
				border-left: 1px solid #BCD4E5;
				border-right: 1px solid #BCD4E5;
				border-bottom: 1px solid #BCD4E5;
				box-shadow: 0px 0px 5px #BCD4E5;
				width: 230px;
				margin-left: -170px;
				color: Black;
				display: none;
			}
			
			.headerlitooleulsubitem_red {
				background-Color: White;
				position: absolute;
				border-left: 1px solid #E5BCD4;
				border-right: 1px solid #E5BCD4;
				border-bottom: 1px solid #E5BCD4;
				box-shadow: 0px 0px 5px #E5BCD4;
				width: 230px;
				margin-left: -170px;
				color: Black;
				display: none;
			}
			
			.headerlitooleulsubitem_gray>li,
			.headerlitooleulsubitem_red>li {
				height: 45px;
				background-color: White;
				padding: 0px 10px;
				border-bottom: 1px solid #E4ECF3;
				font-size: 14px;
				line-height: 26px;
			}
			
			.headerlitoolelisubitemtitle_gray {
				height: 35px !important;
				line-height: 35px !important;
				background-color: #ECF2F7 !important;
				margin: 0px !important;
				color: #8090A0 !important;
				font-size: 14px;
				font-weight: bold;
				border-bottom: 1px solid #BCD4E5 !important;
			}
			
			.headerlitoolelisubitemtitle_red {
				height: 35px !important;
				line-height: 35px !important;
				background-color: #F7ECF2 !important;
				margin: 0px !important;
				color: #B471A0 !important;
				font-size: 14px;
				font-weight: bold;
				border-bottom: 1px solid #E5BCD4 !important;
			}
			
			.headerlitooleulsubitem_gray>li:hover {
				background-Color: #F4F9FC;
			}
			
			.headerlitooleulsubitem_red>li:hover {
				background-color: #FCF4F9;
			}
			
			.ulsubitemitems>li {
				float: left;
				height: 20px;
				font-size: 13px;
				font-weight: normal !important;
				color: #555 !important;
			}
			
			.ulsubitemitems>li:last-child {
				clear: both;
				width: 100%;
				height: 10px;
				margin-top: 8px;
				background-color: #DADADA;
			}
			
			.headerlitools_info {
				height: 45px;
				padding: 0px 10px;
			}
			
			.headeruserface {
				background-image: url('/content/resources/images/logo.png');
				width: 40px;
				height: 40px;
				background-color: white;
				margin: 2px 10px 2px 2px;
				border-radius: 20px;
				float: left;
			}
			
			.headerlitools_ulinfo {
				background-Color: white;
				border-left: 1px solid #D1D1D1;
				border-right: 1px solid #D1D1D1;
				border-bottom: 1px solid #D1D1D1;
				box-shadow: 0px 0px 5px #D1D1D1;
				width: 160px;
				margin-left: -20px;
				color: Black;
				display: none;
			}
			
			.headerlitools_ulinfo>li {
				height: 35px;
				background-color: White;
				padding: 0px 10px;
				font-size: 14px;
				line-height: 36px;
			}
			
			.headerlitools_ulinfo>li:hover {
				background-Color: #FEE188;
			}
			
			.dvcontent {
				padding: 0px 20px;
				margin: 45px auto 0px auto;
				overflow: auto;
			}
			
			.dvpagerecord {
				padding: 6px 12px;
				background-color: #EAEFF2;
				color: #2283C5;
				float: left;
				border: 1px solid #D9D9D9;
				text-decoration: underline;
				font-size: 14px;
				cursor: pointer;
			}
			
			.dvpagerecord:hover {
				cursor: pointer;
			}
			
			.dvpagerecord:hover i {
				text-decoration: underline;
			}
			
			.ulpageRecord {
				max-width: 165px;
				float: left;
				white-space: nowrap;
				overflow: hidden;
				margin: 0px;
				padding: 0px;
			}
			
			.ulpageRecord li {
				margin: 0px;
				padding: 6px 12px;
				background-color: #EAEFF2;
				color: #2283C5;
				display: inline-block;
				font-size: 14px;
				border: 1px solid #D9D9D9;
			}
			
			.ulpageRecord li:hover {
				text-decoration: underline;
				cursor: pointer;
			}
			
			.currentPage {
				background-color: #2468a9 !important;
				color: white !important;
			}
			
			#warn {
				width: 300px;
			}
			
			#warn tr {
				width: 300px;
				height: 20px;
			}
			
			#warn tr td {
				width: 90px;
				height: 20px;
				text-align: center;
			}
			
			iframe {
				border: none;
			}
			img {
				height: 45px;
				display: line-block;
				margin: 0 0 0 885px ;
				vertical-align: middle;
			}
			.ulleftsubitems li:hover{
				background-color:#CDCDCD;
			}
			.headerultools .headerlitools_info a:hover{
				background-color:#ff0000;
			}
			.ulleftmenu li:hover{
			color:#fff;
			}
			.dvheadertools .user {
				display:inline-block;
				color:#fff;
			}
			.dvheadertools .user:hover {
				cursor: pointer;
				color: #2b7dbc;
			}
			.footer {
				position:fixed;
				right:20px;
				bottom:0;
				width:1308px;
				height:40px;
				background-color: #c2c2c2;
				text-align: center;
				line-height:40px;
				color: #201e1b;
			}
		</style>
		<link href="new/css/zy.menu.css" rel="stylesheet" />
	</head>


	<body>
		<div class="dvheader">
			<div class="dvheadertools" style="border-bottom:1px solid #ccc; background-color:#23262f">
				<span class="headerspantitle"  style="color:#fcfcfc;"><strong><font size="5">广东工业大学学生会信息管理系统</font></strong></span>
				<img src="img/user.png" />&nbsp;&nbsp;
				<span class="user">
				<i style="font: normal 400 19px Mircosoft YaHei;">user</i>
				<i>&#9660</i>
				</span>
				<ul class="headerultools">
					<li class="headerlitools_info headerlitools" >
						<a href="loginout.action" style="color:#fcfcfc;display:inline-block;height:45px;padding:0 10px;">退出系统</a>
					</li>
				</ul>
			</div>
     </div>
		<div class="dvcontent">
 
			<ul class="ulleftmenu" style="border-right: 1px solid #ddd;color:#fcfcfc;">

				<li class="limenuitem" style="background-color: #3a3e4a;border-bottom: 1px solid #E5E5E5;
  					 	cursor: pointer;
   					 	line-height: 38px;
    					text-indent: 10px;
    					font-weight: 600;
    					font-size: 16px;
    					border-left: 1px solid #3a3e4a;">
						<p>&nbsp;&nbsp;&nbsp;<font size="4">&#10059系统菜单&#10059</font></p>
					<ul class="ulleftsubitems" style="background-color: #3a3e4a;">
					
						<c:if test="${session.usersession.state==0 }">
							<a href="user_user_list.action" target="right">
								<li style="border-top:1.5px solid #000;">
   									用户管理</li>
							</a>
							<a href="user_member_list.action" target="right">
							    <li>成员管理</li>
							</a>    
							<a href="user_activity_list.action" target="right">
								<li>活动管理</li>
							</a>
							<a href="editUser.action" target="right">
								<li>密码修改</li>
							</a>
						</c:if>
						<c:if test="${session.usersession.state==1 }">
							<a href="user_activity_list.action" target="right">
								<li style="border-top:1.5px solid #000;">活动报名</li>
							</a>
							<a href="user_entry_list.action" target="right">
								<li>已报名活动</li>
							</a>
							<a href="user_user_messageedit.action" target="right">
								<li>个人信息修改</li>
							</a>
							<a href="editUser.action" target="right">
								<li>密码修改</li>
							</a>
						</c:if>
					</ul>
				</li>
			</ul>
			<div style="position: absolute; left: 191px; right: 20px; ">
				<c:if test="${session.usersession.state==0 }">
					<iframe src="user_user_list.action?user.mean=1" scrolling="no"  width="100%" height="1200" name="right" border="none"></iframe>
				</c:if>
				<c:if test="${session.usersession.state==1 }">
					<iframe src="user_activity_list.action" scrolling="no"  width="100%" height="1200" name="right" border="none"></iframe>
				</c:if>
				
			</div>
		</div>
		<div class="footer">
			<b>欢迎使用，当前在线人数:<%=session.getAttribute("UserNumber")%></b>
		</div>
		<script src="new/js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="new/js/plugs/Jqueryplugs.js" type="text/javascript"></script>
		<script src="new/js/_layout.js"></script>
	</body>
	
</html>