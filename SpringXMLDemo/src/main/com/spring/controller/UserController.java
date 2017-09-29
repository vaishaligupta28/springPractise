package com.spring.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController 
{
		//@RequestMapping("/users")
		public ModelAndView getAllUsers()
		{
			//return "test";
			return new ModelAndView("users");
		}
}
