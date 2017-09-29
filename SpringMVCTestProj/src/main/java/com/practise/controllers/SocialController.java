package com.practise.controllers;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practise.model.GmailProfile;
import com.practise.model.Login;
import com.practise.model.User;
import com.practise.services.UserService;
import com.practise.social.Gmail;
import com.practise.utility.Utility;

@Controller
public class SocialController {

	@Autowired
	UserService userService;

	private Object source;

	private Logger logger = Logger.getLogger(SocialController.class);

	@RequestMapping(value = "/loginG")
	public void socialLogin(HttpServletRequest req, HttpServletResponse resp) {
		logger.warn("socialLogin()");
		String lsr = req.getRequestURL().toString();
		String apiRedirectUrl = lsr.substring(0, lsr.lastIndexOf('/'));
		System.out.println(apiRedirectUrl);
		String stateCode = UUID.randomUUID().toString();

		req.getSession().setAttribute("STATE", stateCode);
		String gmailUrl = Gmail.getGmailUrl(apiRedirectUrl, stateCode);
		System.out.println(gmailUrl);
		try {
			resp.sendRedirect(gmailUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping(value = "/postGoogle")
	public String postGmailLogin(HttpServletRequest req, HttpServletResponse resp, Model mav) throws IOException {
		String sessionState = (String) req.getSession().getAttribute("STATE");
		logger.warn(sessionState);
		String stateFromGmail = req.getParameter("state");
		logger.warn(stateFromGmail);
		if (sessionState == null || !sessionState.equals(stateFromGmail)) {
			resp.sendRedirect("loginG");
		}
		String error = req.getParameter("error");
		if (error != null && !error.trim().isEmpty()) {
			resp.sendRedirect("/");
		}
		String authCode = req.getParameter("code");
		String lsr = req.getRequestURL().toString();
		String apiRedirectUrl = lsr.substring(0, lsr.lastIndexOf("/"));

		GmailProfile profile = Gmail.authUser(authCode, apiRedirectUrl);
		User user = null;
		try {
			user = userService.getUserByEmailID(profile.getEmails().get(0).getValue());
		} catch (Exception e) {
			logger.error("Server error");
		}
		HttpSession session = req.getSession(true);
		if (user == null) {
			logger.warn("====");
			user = new User();
			user.setName(profile.getDisplayName());
			user.setFirstname(profile.getName().getGivenName());
			user.setLastname(profile.getName().getFamilyName());
			user.setEmail(profile.getEmails().get(0).getValue());
			userService.register(user);
		}
		session.setAttribute("user", user);
		return "home";
	}
}
