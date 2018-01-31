package com.bh;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

// 监听request的创建
public class MyHttpServletRequest implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request创建");
	}
}