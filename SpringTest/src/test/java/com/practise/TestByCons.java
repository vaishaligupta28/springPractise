package com.practise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByCons {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		C c = (C) context.getBean("c");
		c.display();
	}

}
