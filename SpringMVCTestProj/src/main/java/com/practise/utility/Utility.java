package com.practise.utility;

import com.practise.model.GoogleUser;
import com.practise.model.User;

public class Utility {

	public static void setToModel(Object target, GoogleUser googleUser) {
		if(target instanceof User) {
			User user = (User) target;
			user.setName(googleUser.getName());
			user.separateName(googleUser.getName());
			user.setEmail(googleUser.getEmail());
		}
	}
}
