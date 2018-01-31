package com.bh;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("ÃÌº” Ù–‘");
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("“∆≥˝ Ù–‘");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("ÃÊªª");
	}
}