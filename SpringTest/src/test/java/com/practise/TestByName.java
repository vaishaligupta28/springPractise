package com.practise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByName {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		A objA = (A) context.getBean("a");
		objA.display();
	}
}
