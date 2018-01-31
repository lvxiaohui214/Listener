package com.bh;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//监听session的创建与销毁
//@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	
	public int count; //在线人数
	
    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
    	count++;
    	sessionEvent.getSession().getServletContext().setAttribute("Count",count);
    	System.out.println("session~~~创建");
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent)  { 
    	count--;
    	sessionEvent.getSession().getServletContext().removeAttribute("Count");
    	System.out.println("session~~~销毁");
    }
}