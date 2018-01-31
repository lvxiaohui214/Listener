package com.bh;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


//���������ContextListener�Ĵ���������
public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String contextName = servletContext.getServletContextName();
		System.out.println(contextName+"---����---");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String contextName = servletContext.getServletContextName();
		System.out.println(contextName+"---����---");
	}

}
