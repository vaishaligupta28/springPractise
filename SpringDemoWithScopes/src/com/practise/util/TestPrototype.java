package com.practise.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practise.bean.CheckPrototype;

public class TestPrototype {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CheckPrototype obj1 = (CheckPrototype) context.getBean("checkPrototype");
		obj1.setMessage("created multiple instance, setting message only once");
		obj1.getMessage();
		
		CheckPrototype obj2 = (CheckPrototype) context.getBean("checkPrototype");
		obj2.getMessage();
		
		CheckPrototype obj3 = (CheckPrototype) context.getBean("checkPrototype");
		obj3.getMessage();
	}
}