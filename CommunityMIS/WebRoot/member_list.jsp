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
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
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
                <div class="result-title">
                    <div class="result-list">
                    
                        <a href="user_member_edit.action" style="float:right;"><i class="icon-font">&#10004</i>添加</a>
                        <font style="background: none;border: 0;color: red;font-weight: 900;font-size: 24px;"><s:actionmessage /></font>
                   						   成员姓名：  <input class="common-text required" id="title" 
                                    	name="member.name" size="50" value="${member.name }" type="text"/>
                                    	<input style="width: 80px;height: 28px;
    border: 1px solid #aeaeae;border-radius: 5px;" value="查询" type="button" onclick="location.href='spe_member.jsp'" />                                   	
                    </div>
                </div>
                
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                           
							<th width="2%" style="text-align: center;">
								编号
							</th>
							<th width="8%" style="text-align: center;">
								成员姓名
							</th>
							<th width="5%" style="text-align: center;">
								性别
							</th>
							
							<th width="8%" style="text-align: center;">
								所属部门
							</th>
							
							<th width="8%" style="text-align: center;">
								职务
							</th>
							<th width="8%" style="text-align: center;">
								联系电话
							</th>
							<th width="10%" style="text-align: center;">
								操作
							</th>
                        </tr>
                           <c:forEach items="${memberlist }" var="list">
							<tr>
								<td style="text-align: center;">
									${list.id }
								</td>
								<td style="text-align: center;">
									${list.name }
								</td>
								<td style="text-align: center;">
									${list.sex }
								</td>	
								<td style="text-align: center;">
									${list.department }
								</td>
								<td style="text-align: center;">
									${list.duty }
								</td>
								<td style="text-align: center;">
									${list.phone }
								</td>
								<td style="text-align: center;">
								
										<a href="user_member_edit.action?member.id=${list.id}"
											class="tablelink">修改</a>&nbsp;&nbsp;
										<a href="user_member_del.action?member.id=${list.id}"
											class="tablelink" onClick="return ConfirmDel();">删除</a>
											
								</td>
							</tr>
						</c:forEach>
                    </table>
                    <div class="pagin">
					<div class="message">
						共
						<i class="blue">${totalCount }</i>条记录，当前显示第&nbsp;
						<i class="blue">${currentPage }&nbsp;/&nbsp;${totalPage
							}&nbsp;</i>页
					</div>
					<ul class="paginList">
						<li class="paginItem">
							<a
								href="user_member_list.action"
								style="width: 80px;">首页</a>
						</li>

						<c:choose>
							<c:when test="${currentPage == 1 }">
								<li class="paginItem">
									<a
										href="user_member_list.action?currentPage=1"
										style="width: 80px;">上一页</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="paginItem">
									<a
										href="user_member_list.action?currentPage=${currentPage-1 }"
										style="width: 80px;">上一页</a>
								</li>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${currentPage == totalPage }">
								<li class="paginItem">
									<a
										href="user_member_list.action?currentPage=${totalPage}"
										style="width: 80px;">下一页</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="paginItem">
									<a
										href="user_member_list.action?currentPage=${currentPage+1 }"
										style="width: 80px;">下一页</a>
								</li>
							</c:otherwise>
						</c:choose>

						<li class="paginItem">
							<a
								href="user_member_list.action?currentPage=${totalPage}"
								style="width: 80px;">尾页</a>
						</li>
					</ul>
				</div>

                </div>
        </div>
    </div>
</div>
</body>
</html>