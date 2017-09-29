package com.practise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

public class TestHelloBean {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("helloSpring-config.xml");
		HelloBean obj = (HelloBean) context.getBean("helloBean");
		obj.printHello();
		context.registerShutdownHook();
	}
}
