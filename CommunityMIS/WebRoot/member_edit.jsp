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
               <form action="user_member_save.action" method="post">
				<input type="hidden" name="member.id" value="${member.id }" />
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>成员姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="member.name" size="50" value="${member.name }" type="text"/>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>性别：</th>
                                <td>
                                    <select  class="common-text required" name="member.sex">
										<option value="男" <c:if test="${member.sex=='男' }">selected="selected"</c:if>>男</option>
										
										<option value="女" <c:if test="${member.sex=='女' }">selected="selected"</c:if>>女</option>
									</select>
                                </td>
                            </tr>
                         	 <tr>
                                <th><i class="require-red">*</i>所属部门：</th>
                                <td>
                                    <input class="common-text required" id="title" 
                                    	name="member.department" size="50" value="${member.department }" type="text"/>
                                </td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>职务：</th>
                                <td>
                                    <input class="common-text required" id="title" 
                                    	name="member.duty" size="50" value="${member.duty }" type="text"/>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>联系电话：</th>
                                <td>
                                    <input class="common-text required" id="title" 
                                    	name="member.phone" size="50" value="${member.phone }" type="text"/>
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