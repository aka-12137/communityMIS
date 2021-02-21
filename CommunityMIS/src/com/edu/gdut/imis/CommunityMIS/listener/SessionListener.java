package com.edu.gdut.imis.CommunityMIS.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.edu.gdut.imis.CommunityMIS.bean.User;
import com.edu.gdut.imis.CommunityMIS.util.Constants;


public class SessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Session创建:"+arg0.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Session销毁:"+arg0.getSession().getId());
		User user = (User) arg0.getSession().getAttribute(Constants.USER_SESSION);
		if(user != null && user.getUsername().equals(Constants.loginuser)){
			Constants.loginuser = "";
			Constants.loginlogid = null;
		}
	}

}
