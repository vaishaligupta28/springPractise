package com.practise.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.practise.model.User;
import com.practise.services.UserService;
import com.practise.validator.UserValidator;

@Controller
public class RegisterController {

	@Autowired
	UserService userService;

	@Autowired
	UserValidator userValidator;

	@RequestMapping(value = "/register")
	public ModelAndView showRegister(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("register controller method-- showregister()");
		ModelAndView mav = new ModelAndView("register");
		User user = new User(); /* creating an empty user model */
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String addUser(HttpServletRequest req, HttpServletResponse resp, @ModelAttribute("user") User user,
			BindingResult res,Model mav) throws IOException {
		System.out.println("register controller method-- addUser()");

		userValidator.validate(user, res);
		if (res.hasErrors()) {
			System.out.println(res.toString());
			return "register";
		}

		if (userService.getUserByEmailID(user.getEmail()) != null) {
			mav.addAttribute("alreadyInUseMsg", "Email already in use.");
			return "register";
		} else {
			if (userService.getUserByUsername(user.getUsername()) == null) {
				mav.addAttribute("alreadyInUseMsg", "Username already in use");
				return "register";
			}
		}
		userService.register(user);
		return "redirect:/";
	}
}
