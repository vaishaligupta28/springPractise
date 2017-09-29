package com.practise.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsInjectInheritingBean {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ConsInjectInheritingBean  obj = (ConsInjectInheritingBean) context.getBean("childBean");
		obj.display();
	}
}
