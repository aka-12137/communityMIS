$(function(){
	$("#login").check(function(){
		var username=$("#username").val();
		var password=$("#password").val();
		var error=$("#errormassage").val();
		if (username!=null&&password!=null){
			$.post("${pageContext.request.contextPath}/login.action",
			{"username":username,"password":password},
			function(error){
				if(error==0){
					alert("请维护登录信息完整！");
					return false;
				}else if(error==1){
					alert("用户尚未通过审核，请稍后再试")
					return false;
				}
				else if(error==2){
					alert("用户名或密码错误！")
					return false;
				}
				else{
					alert("登录成功！")
				}
			}
			)
		}
		
	}
			)
}
		)