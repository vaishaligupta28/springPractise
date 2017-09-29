package com.practise.di;

public class User {
	private String name;
	private String email;
	private static int c=1;
	User(String name, String email)
	{
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User"+ c++ +": [name=" + name + ", email=" + email + "]";
	}	
}
