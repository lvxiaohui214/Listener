package com.bh.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @Description 学习使用HttpSessionBindingListener
 * @author lxh
 * @date 2018-01-30 20:42
 */
public class User implements Serializable, HttpSessionBindingListener
	,HttpSessionActivationListener{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("user绑定到session中。。。");
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("user从session中解绑。。。");
	}
	
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("钝化");
	}
	
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("活化");
	}
}