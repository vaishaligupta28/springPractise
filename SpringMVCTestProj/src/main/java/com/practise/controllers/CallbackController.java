package com.practise.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.practise.model.GoogleUser;
import com.practise.model.Login;
import com.practise.model.User;
import com.practise.services.UserService;
import com.practise.utility.SetUp;
import com.practise.utility.Utility;

@Controller
public class CallbackController {

	@Autowired
	public UserService userService;

	private GoogleUser googleUser;

	@RequestMapping(value = "/afterGoogleVerify")
	public void getGoogleData(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Object source = req.getAttribute("source");
			String code = req.getParameter("code");
			System.out.println(code);
			String urlParameters = "code=" + code + "&client_id=" + SetUp.CLIENT_ID + "&client_secret="
					+ SetUp.CLIENT_SECRET + "&redirect_uri=" + SetUp.REDIRECT_URL + "&grant_type=authorization_code";

			System.out.println(urlParameters);

			/*
			 * Sending the urlparameters to the requestheader or httpurl as a request since
			 * there is no browser or client, well have to send it through connection
			 */
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection conn = url.openConnection();
			// HttpURLConnection hconn = (HttpURLConnection) conn;
			// hconn.setRequestMethod( "GET" );
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();

			String line1 = "";

			// conn.getInputStream() will read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				line1 = line1 + line;
			}
			System.out.println(line1);// json response in string format

			Type typeOfT = new TypeToken<Map<String, String>>() {
			}.getType();
			Map<String, String> map = new Gson().fromJson(line1, typeOfT);

			String s = map.get("access_token");
			url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + s);
			conn = url.openConnection();

			// conn.addRequestProperty("Authorization", "Bearer "+s);

			line1 = "";
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				line1 = line1 + line;
			}
			System.out.println("CallbackController- doSocialSignInSignUp()---" + line1);
			// .out.println(line1);
			googleUser = (GoogleUser) new Gson().fromJson(line1, GoogleUser.class);
			writer.close();
			reader.close();
			System.out.println(googleUser);
			if (source instanceof User) {
				resp.sendRedirect("signUpValid");
			} else {
				resp.sendRedirect("signInValid");
			}

		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "doSocialSignIn")
	public void doSocialSignIn(HttpServletRequest req, HttpServletResponse resp, @ModelAttribute("user") User user) {
		CallbackController.goToGoogleVerify(req, resp, user);
	}

	@RequestMapping(value = "doSocialSignUp")
	public void doSocialSignUp(HttpServletRequest req, HttpServletResponse resp,
			@ModelAttribute("newLogin") Login login) {
		CallbackController.goToGoogleVerify(req, resp, login);
	}

	private static void goToGoogleVerify(HttpServletRequest req, HttpServletResponse resp, Object source) {
		req.setAttribute("source", source);
		String redirectUrl = "https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8081/SpringMVCTestProj/afterGoogleVerify&response_type=code&client_id=1097381024907-lhi6fj5kavmbbij90ipagvvqaepbrvla.apps.googleusercontent.com&approval_prompt=force";
		try {
			resp.sendRedirect(redirectUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "signUpValid")
	private String signUpValidation(HttpServletRequest req, HttpServletResponse resp, Model mav) {
		System.out.println("signUpValid" + googleUser);
		if ((userService.getUserByEmailID(googleUser.getEmail())) == null) {
			User user = new User();
			Utility.setToModel(user, googleUser);
			userService.register(user);
			HttpSession session = req.getSession(true);
			session.setAttribute("userId", user.getUserId());
			mav.addAttribute("user", user);
			return "home";
		} else {
			mav.addAttribute("login", new Login());
			mav.addAttribute("alreadyHaveAccMsg", "You already have an account");
			return "userAlreadyPresentPage";
		}
	}

	@RequestMapping(value = "signInValid")
	private String signInValidation(HttpServletRequest req, HttpServletResponse resp, Model mav) {
		User user = null;
		User userCheck = userService.getUserByEmailID(googleUser.getEmail());
		System.out.println("signInValid" + googleUser);
		HttpSession session = req.getSession(true);
		if (userCheck == null) {
			user = new User();
			Utility.setToModel(user, googleUser);
			userService.register(user);
		}
		else {
			user = userCheck;
		}
		session.setAttribute("userId", user.getUserId());
		mav.addAttribute("user", user);
		return "home";
	}
}
