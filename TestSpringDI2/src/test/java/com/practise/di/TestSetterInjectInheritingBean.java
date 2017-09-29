package com.practise.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetterInjectInheritingBean {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		SetterInjectInheritingBean  obj = (SetterInjectInheritingBean) context.getBean("childBean");
		obj.display();
	}
}
