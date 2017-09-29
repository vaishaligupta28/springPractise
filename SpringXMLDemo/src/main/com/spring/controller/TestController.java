package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//@Controller
@SuppressWarnings("deprecation")
public class TestController extends MultiActionController
{
	public TestController() {
		System.out.println("cons");
	}
	

	@Override
	protected void bind(HttpServletRequest request, Object command) throws Exception {
		System.out.println("bind");
	}
	
	//@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response ) throws Exception 
	{
		System.out.println("test");
		//return "test";
		return new ModelAndView("test");
	}
}
