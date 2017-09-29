package com.practise.dao;

import com.practise.model.Login;
import com.practise.model.User;

public interface UserDao {

	void register(User user);
	User loginUser(Login login);
	int changePass(User user);
	User getUserByEmailID(String emailId);
	User getUserByUsername(String username);
}
