package com.practise.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.practise.model.Login;
import com.practise.model.User;
import com.practise.utility.MyBatisUtil;

@Repository
public class UserDaoImpl{

	public void register(User user) {
		System.out.println("UserDaoImpl- register()");
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			userDao.register(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public User loginUser(Login login) {
		System.out.println("UserDaoImpl- register()");
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println("Username: " + login.getUsername());
			System.out.println("Password: " + login.getPassword());
			return userDao.loginUser(login);
		} finally {
			sqlSession.close();
		}
	}
	

	public int changePass(User user) {
		System.out.println("daoImpl - changePass()");
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			int flag = userDao.changePass(user);
			System.out.println("rows affected:"+flag);
			sqlSession.commit();
			return flag;
		} finally {
			sqlSession.close();
		}
	}
	
	public User getUserByEmailID(String emailId) {
		System.out.println("daoImpl  - getUserByEmailID()");
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			return userDao.getUserByEmailID(emailId);
		} finally {
			sqlSession.close();
		}
	}

	public User getUserByUsername(String username) {
		System.out.println("daoImpl  - getUserByEmailID()");
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			return userDao.getUserByUsername(username);
		} finally {
			sqlSession.close();
		}
	}

	public void createUser(String userId, User user) {
		// TODO Auto-generated method stub
		
	}
}
