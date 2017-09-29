package com.practise.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSIwithMap {
	public static void main(String args[]) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		SIwithMap obj = (SIwithMap)context.getBean("checkSIwithMap");
		obj.display();
	}
}
