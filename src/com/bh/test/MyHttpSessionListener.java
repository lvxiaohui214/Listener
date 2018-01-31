package com.bh.test;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		
		//��ȡ������е�session����
		@SuppressWarnings("unchecked")
		List<HttpSession> sessions = (List<HttpSession>) session.getServletContext().getAttribute("sessions");
		
		sessions.add(session);
		
		System.out.println("�����"+session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("session---����---");
	}
}