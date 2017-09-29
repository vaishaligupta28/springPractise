package com.practise.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCIwithMap {
	public static void main(String args[]) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		CIwithMap obj = (CIwithMap)context.getBean("checkCIwithMap");
		obj.display();
	}
}
