package com.practise.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practise.model.Login;
import com.practise.model.User;
import com.practise.services.EmailService;
import com.practise.services.UserService;
import com.practise.validator.UserValidator;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private EmailService emailService;

	private int OTP;
	private String emailID;

	@RequestMapping(value = "/")
	public ModelAndView showLogin(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LoginController-- showLogin()");
		// String msg = (String) mav.asMap().get("messageAfterRegis");
		// System.out.println(msg);
		ModelAndView mav = new ModelAndView("login");
		Login newLogin = new Login();
		mav.addObject("newLogin", newLogin);
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest req, HttpServletResponse resp,
			@ModelAttribute("newLogin") Login newLogin, BindingResult res, Model mav) {
		System.out.println("LoginController-- loginProcess()");
		// ModelAndView mav = null;

		userValidator.validate(newLogin, res);

		if (res.hasErrors()) {
			System.out.println(res.toString());
			return "login";
		}

		User user = userService.loginUser(newLogin);

		if (null != user) {
			mav.addAttribute("user", user);
			return "home";
		} else {
			// mav = new ModelAndView("login");
			mav.addAttribute("message", "Username or Password is inavlid!!");
			return "login";
		}
		// return mav;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logoutUser(HttpSession session) {
		System.out.println(session.getId());
		session.invalidate();
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("logoutMsg", "Logged out successfully.");
		mav.addObject("newLogin", new Login());
		return mav;
	}

	@RequestMapping(value = "/forgotPassword")
	public String forgotPassword(Model mav) {
		System.out.println("Login Controller- forgot pass");
		mav.addAttribute("user", new User());
		return "forgotPassword";
	}

	@RequestMapping(value = "/sendOTP", method = RequestMethod.POST)
	public String sendOTP(@ModelAttribute(value = "user") User user, BindingResult res, Model mav) {

		System.out.println("Login Controller- reset password");

		emailID = user.getEmail();
		// check if the email id is valid and registered with us.
		if (userService.getUserByEmailID(emailID) == null) {
			mav.addAttribute("userDoesNotExist", "User does not exist");
			return "forgotPassword";
		} else {
			OTP = emailService.sendMail(emailID);
			mav.addAttribute("OTP", OTP);
			return "checkOTP";
		}
	}

	@RequestMapping(value = "/reset")
	public String resetPassword(@RequestParam(value = "OTP") int formOTP, Model mav) {

		System.out.println("Login Controller- reset password after clicking the link");
		if (formOTP == OTP) {
			mav.addAttribute("login", new Login());
			return "resetPassword";
		} else {
			mav.addAttribute("invalidOTPmsg", "Invalid OTP");
			return "checkOTP";
		}
	}

	@RequestMapping(value = "resendOTP")
	public String sendOTP(Model mav) {
		System.out.println("Login Controller- reset password");
		OTP = emailService.sendMail(emailID);
		mav.addAttribute("OTP", OTP);
		mav.addAttribute("OTPmsg", "OTP sent");
		return "checkOTP";
	}

	@RequestMapping(value = "/changePass", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute(value = "login") Login login, BindingResult res, Model mav) {
		System.out.println("Login Controller- changePassword() method");

		// check for valid password, and both passwords matching
		userValidator.validate(login, res);
		if (res.hasErrors()) {
			System.out.println(res.toString());
			return "resetPassword";
		}

		User user = userService.getUserByEmailID(emailID);
		user.setPassword(login.getPassword());
		int rowsAffected = userService.changePass(user);
		if (rowsAffected > 0) {
			mav.addAttribute("newLogin", login);
			mav.addAttribute("passChangeMsg", "Password Changed successfully!!");
			return "login";
		} else {
			mav.addAttribute("tryagainMsg", "Sorry!!Try Again.");
			return "resetPassword";
		}
	}
}
