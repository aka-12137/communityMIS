<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="background-color:#efefef;">
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <style>
    	.result-tab tr:hover{background: #cbcbcb;}
    	.result-tab th,.result-tab td{padding:5px;border-left:2px solid #aeaeae!important;border-top:2px solid #aeaeae!important;border-bottom: 2px solid #aeaeae!important;border-right: 2px solid #aeaeae!important;}
    	.pagin .paginList .paginItem:hover{background:#cbcbcb!important;}
    	input:hover{
    	background-color:#aeaeae;
    	}
    </style>
</head>
<body>
<div class="container clearfix">
    <div class="main-wrap">
        <div class="result-wrap" style="background-color:#efefef;">
            <div class="result-content">
               <form action="user_activity_save.action" method="post">
				<input type="hidden" name="activity.id" value="${activity.id }" />
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>活动主题：</th>
                                <td>
                                    <input class="common-text required" id="title" name="activity.theme" size="50" value="${activity.theme }" type="text"/>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>主办方：</th>
                                <td>
                                    <input class="common-text required" id="title" 
                                    	name="activity.sponsor" size="50" value="${activity.sponsor }" type="text"/>
                                </td>
                            </tr>
                         	 <tr>
                                <th><i class="require-red">*</i>地点：</th>
                                <td>
                                    <input class="common-text required" id="title" 
                                    	name="activity.place" size="50" value="${activity.place }" type="text"/>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>内容：</th>
                                <td>
                                   <textarea name="activity.content" rows="10" cols="50" style="border-radius: 5px;">${activity.content }</textarea>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>上传文件：</th>
                                <td>
                                   <input type="file" class="common-text required" />
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn6" value="提交" type="submit"/>
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button"/>
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>