package com.practise.di;

public class User {
	private String name;
	private String email;
	private static int c = 1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static int getC() {
		return c;
	}

	public static void setC(int c) {
		User.c = c;
	}

	@Override
	public String toString() {
		return "User" + c++ + ": [name=" + name + ", email=" + email + "]";
	}
}
