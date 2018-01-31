package com.bh;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//����session�Ĵ���������
//@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	
	public int count; //��������
	
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
    	count++;
    	sessionEvent.getSession().getServletContext().setAttribute("Count",count);
    	System.out.println("session~~~����");
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent)  { 
    	count--;
    	sessionEvent.getSession().getServletContext().removeAttribute("Count");
    	System.out.println("session~~~����");
    }
}