package com.practise.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHttpReqScope {
	@SuppressWarnings("resource")
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	CheckHttpSessionScope obj1 = (CheckHttpSessionScope) context.getBean("checkPrototype");
	obj1.setMessage("created multiple instance, setting message only once");
	obj1.getMessage();
	
	CheckHttpSessionScope obj2 = (CheckHttpSessionScope) context.getBean("checkPrototype");
	obj2.getMessage();
	
	CheckHttpSessionScope obj3 = (CheckHttpSessionScope) context.getBean("checkPrototype");
	obj3.getMessage();
}
