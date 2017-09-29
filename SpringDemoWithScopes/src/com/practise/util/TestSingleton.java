package com.practise.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practise.bean.CheckSingleton;

public class TestSingleton {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CheckSingleton obj1 = (CheckSingleton) context.getBean("checkSingleton");
		obj1.setMessage("created multiple instance, setting message only once");
		obj1.getMessage();
		
		CheckSingleton obj2 = (CheckSingleton) context.getBean("checkSingleton");
		obj2.getMessage();
		
		CheckSingleton obj3 = (CheckSingleton) context.getBean("checkSingleton");
		obj3.getMessage();
	}
}
