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
 * @Description ��ʱ����session
 * @author lxh
 * @date 2018-01-30 21:40
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		//ͨ���¼�Դ��ȡ�¼�Դ����
		ServletContext application = servletContextEvent.getServletContext();
		
		//�������������洢session-----�̰߳�ȫ
		List<HttpSession> list = Collections.synchronizedList(new ArrayList<HttpSession>());
		
		application.setAttribute("sessions",list);//��������
		
		Timer t = new Timer();  //������ʱ������
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("��ʼɨ���ˡ�����");
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
						HttpSession session = (HttpSession) iterator.next();
						long l = System.currentTimeMillis()-session.getLastAccessedTime();
						if(l > 5){ //�������5s���Ƴ�
							System.out.println("�Ƴ���"+session.getId());
							session.invalidate(); //����session
							iterator.remove(); //�Ƴ�session
						}
				}
			}
		},2000,5000);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("application---����");
	}
}