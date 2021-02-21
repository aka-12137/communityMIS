package com.edu.gdut.imis.CommunityMIS.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
	private int UserNumber = 0;
	public void sessionCreated(HttpSessionEvent arg0) {
		UserNumber ++;
		arg0.getSession().setAttribute("UserNumber", UserNumber);
	}
	public void sessionDestroyed(HttpSessionEvent arg0) {
		UserNumber --;
		arg0.getSession().setAttribute("UserNumber",UserNumber);
	}
}
