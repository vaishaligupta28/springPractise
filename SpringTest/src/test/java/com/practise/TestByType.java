package com.practise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByType {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		C objC = (C) context.getBean("c");
		objC.display();
	}
}
