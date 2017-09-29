package com.practise.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCIWithList {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		CIwithList obj = (CIwithList) context.getBean("checkDIwithColl");
		obj.display();
	}
}
