package com.bh.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

/**
 * @Description 定时销毁session
 * @author lxh
 * @date 2018-01-30 21:40
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		//通过事件源获取事件源对象
		ServletContext application = servletContextEvent.getServletContext();
		
		//创建集合用来存储session-----线程安全
		List<HttpSession> list = Collections.synchronizedList(new ArrayList<HttpSession>());
		
		application.setAttribute("sessions",list);//放入域中
		
		Timer t = new Timer();  //创建定时器任务
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("开始扫描了。。。");
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
						HttpSession session = (HttpSession) iterator.next();
						long l = System.currentTimeMillis()-session.getLastAccessedTime();
						if(l > 5){ //如果超过5s则移除
							System.out.println("移除了"+session.getId());
							session.invalidate(); //销毁session
							iterator.remove(); //移除session
						}
				}
			}
		},2000,5000);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("application---销毁");
	}
}