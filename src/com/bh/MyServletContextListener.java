package com.bh;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


//监听域对象ContextListener的创建、销毁
public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String contextName = servletContext.getServletContextName();
		System.out.println(contextName+"---创建---");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String contextName = servletContext.getServletContextName();
		System.out.println(contextName+"---销毁---");
	}

}
