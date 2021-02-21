<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="background-color:#efefef;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>默认</title>
<style>
    	.result-tab tr:hover{background: #cbcbcb;}
    	.result-tab th,.result-tab td{padding:5px;border-left:2px solid #aeaeae!important;border-top:2px solid #aeaeae!important;border-bottom: 2px solid #aeaeae!important;border-right: 2px solid #aeaeae!important;}
    	.pagin .paginList .paginItem:hover{background:#cbcbcb!important;}
    	input:hover{
    	background-color:#aeaeae;
    	}
    </style>
</head>
<body >	
    
    <div class="mainindex">   
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>${session.usersession.username }&nbsp;
    <c:choose>
    	<c:when test="${session.hours<=12 }">
    		上午
    	</c:when>
    	<c:when test="${session.hours>12 and session.hours<=18 }">
    		下午
    	</c:when>
    	<c:when test="${session.hours>18 }">
    		晚上
    	</c:when>
    	<c:otherwise>
    		您
    	</c:otherwise>
    </c:choose>
    	
          好，欢迎登录信息管理系统</b>
    
    </div>
    
    <div class="xline"></div>
    <div class="box"></div>

</div>
    
</body>

</html>

