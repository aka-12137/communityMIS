package com.edu.gdut.imis.CommunityMIS.action;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.edu.gdut.imis.CommunityMIS.bean.User;
import com.edu.gdut.imis.CommunityMIS.dao.UserDAO;
import com.edu.gdut.imis.CommunityMIS.util.Constants;
import com.edu.gdut.imis.CommunityMIS.util.MD5Utils;
import com.edu.gdut.imis.CommunityMIS.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDAO userDAO;
	private String username;
	private String password;
	private String verifycode;
	private String oldPassword;
	private String newPassword;
	private String errormessage;
	
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public String login() {
		ActionContext context = ActionContext.getContext();
		
		User user = (User) context.getSession().get(Constants.USER_SESSION);
		if (StringUtils.isEmpty(username) | StringUtils.isEmpty(password)) {
			this.errormessage = "请维护登录信息完整！" ;
			return INPUT;
		}

		
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		try {
			
			List<User> users = userDAO.findByExample(user);
			
			if (users != null && !users.isEmpty()) {
				user = users.iterator().next();
				if(user.getMean()!=null && user.getMean()==1){
					this.errormessage= "用户尚未通过审核，请稍后再试";
					return  INPUT;
				}
				context.getSession().put(Constants.USER_SESSION, user);
			} else {
				this.errormessage = "用户名或密码错误！";
				return INPUT;
			}
			
			
			
			if (!username.equals(Constants.loginuser)) {
				Constants.loginuser = user.getUsername();
			}
			
			Date d = new Date();
			context.getSession().put(Constants.hours, d.getHours());
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			this.errormessage = "数据连接出错！！";
			return INPUT;
		}
		
		return SUCCESS;
	}

	public String loginout() {
		ActionContext.getContext().getSession()
				.put(Constants.USER_SESSION, null);
		Constants.loginuser = "";
		ActionContext.getContext().getSession().put(Constants.loginuser,null);
		return SUCCESS;
	}

	public String modifyPassword() {

		User user = (User) ActionContext.getContext().getSession()
				.get(Constants.USER_SESSION);
		oldPassword = MD5Utils.generatePassword(oldPassword);
		if (user == null || !oldPassword.equals(user.getPassword())) {
			addActionError("旧密码输入错误.");
			return INPUT;
		}

		userDAO.updatePwdForUsername(user.getUsername(),
				MD5Utils.generatePassword(newPassword));
		addActionMessage("密码修改成功.");

		return SUCCESS;

	}
	
	public String regedit(){
		
		return SUCCESS;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}

