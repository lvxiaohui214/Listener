package com.bh;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

// ����request�Ĵ���
public class MyHttpServletRequest implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request����");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request����");
	}
}