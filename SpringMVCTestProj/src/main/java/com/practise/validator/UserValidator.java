package com.practise.validator;

import org.springframework.validation.Validator;

import com.practise.model.Login;
import com.practise.model.User;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class UserValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9@#$%_-]{6,14}$";
	private static final String PASSWORD_PATTERN = "^.*(?=.{8,15})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
	private static final String FIRSTNAME_PATTERN = "^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$";
	private static final String LASTNAME_PATTERN = "^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$";

	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	private boolean patternValidator(String regex, String inputString) {
		return Pattern.matches(regex, inputString);
	}

	private boolean isEmptyOrWhiteSpace(String inputString) {
		if (inputString == null || inputString.trim().length() == 0)
			return true;

		return false;
	}

	public void validate(Object target, Errors errors) {

		User user = null;
		Login login = null;

		// validating during regisatrtion
		if (target instanceof User) {
			user = (User) target;

			// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.name",
			// "Username is required.");

			// validating username
			if (isEmptyOrWhiteSpace(user.getUsername()))
				errors.rejectValue("username", "error.register.name", "Username is required");
			else {
				if (!patternValidator(USERNAME_PATTERN, user.getUsername()))
					errors.rejectValue("username", "error.register.patternName", "Username not allowed");
			}

			// validating password
			if (isEmptyOrWhiteSpace(user.getPassword()))
				errors.rejectValue("password", "error.register.password", "Password is required");
			else {
				if (user.getPassword().length() < 8 || user.getPassword().length() > 15)
					errors.rejectValue("password", "error.register.length",
							"Password must contain minimum 8 and maximum 15 characters");
				else {
					if (!patternValidator(PASSWORD_PATTERN, user.getPassword()))
						errors.rejectValue("password", "error.register.patternPwd",
								"Password should contain atleast one digit,one lowecase charactere, one uppercase character and one special symbol");
				}
			}
			// validating firstname
			if (isEmptyOrWhiteSpace(user.getFirstname()))
				errors.rejectValue("firstname", "error.register.fistname", "Firstname is required");
			else {
				if (!patternValidator(FIRSTNAME_PATTERN, user.getFirstname()))
					errors.rejectValue("firstname", "error.register.patternFirstname", "Invalid first name");
			}

			// validating last name
			if (isEmptyOrWhiteSpace(user.getLastname()))
				errors.rejectValue("lastname", "error.register.lastname", "Lastname is required");
			else {
				if (!patternValidator(LASTNAME_PATTERN, user.getLastname()))
					errors.rejectValue("lastname", "error.register.patternLastname", "Invalid last name");
			}

			// validating email
			if (isEmptyOrWhiteSpace(user.getEmail()))
				errors.rejectValue("email", "error.register.email", "Email is required");
			else {
				if (!patternValidator(EMAIL_PATTERN, user.getEmail()))
					errors.rejectValue("email", "error.register.patternEmail", "Invalid email address");
			}
		}

		// validating using login
		else {
			login = (Login) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.login.username",
					"Username cannot be left empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.login.password",
					"Password cannot be left empty");
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.login.password",
//					"Password cannot be left empty");
			

			if (!isEmptyOrWhiteSpace(login.getPassword()) && !isEmptyOrWhiteSpace(login.getConfirmPassword())) {

				if (login.getPassword().length() < 8 || login.getPassword().length() > 15)
					errors.rejectValue("password", "error.reset.length",
							"Password must contain minimum 8 and maximum 15 characters");
				else {
					System.out.println(login.getPassword());
					System.out.println(patternValidator(PASSWORD_PATTERN, login.getPassword()));
					if (!patternValidator(PASSWORD_PATTERN, login.getPassword())) {
						System.out.println("-----");
						errors.rejectValue("password", "error.reset.patternPwd",
								"Password should contain atleast one digit,one lowecase charactere, one uppercase character and one special symbol");
					
					}else {
						System.out.println("2222");
						if (!(login.getPassword().equalsIgnoreCase(login.getConfirmPassword()))) {
							System.out.println("3333");
							errors.rejectValue("confirmPassword", "error.reset.match", "Passwords do not match");
						}
					}
				}
			}
		}
	}
}
