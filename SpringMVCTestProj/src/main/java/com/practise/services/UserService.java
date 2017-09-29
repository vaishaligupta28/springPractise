package com.practise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practise.dao.UserDao;
import com.practise.dao.UserDaoImpl;
import com.practise.model.Login;
import com.practise.model.User;

@Service
public class UserService {

	@Autowired
	private UserDaoImpl daoImpl;

	@Transactional
	public void register(User user) {
		System.out.println("user service- register()");
		daoImpl.register(user);
	}

	public User loginUser(Login login) {
		// TODO Auto-generated method stub
		System.out.println("user service- validateUser()");
		System.out.println("Username: " + login.getUsername());
		System.out.println("Password: " + login.getPassword());
		return daoImpl.loginUser(login);
	}

	public int changePass(User user) {
		System.out.println("user service - changePass()");
		return daoImpl.changePass(user);
	}

	public User getUserByEmailID(String emailId) {
		System.out.println("user service - getUserByEmailID()");
		return daoImpl.getUserByEmailID(emailId);
	}

	public User getUserByUsername(String username) {
		System.out.println("user service - getUserByEmailID()");
		return daoImpl.getUserByUsername(username);
	}
}
