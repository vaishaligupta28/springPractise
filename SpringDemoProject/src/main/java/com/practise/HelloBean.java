package com.practise;

import org.springframework.beans.factory.DisposableBean;

public class HelloBean implements DisposableBean {
	private String firstName;
	private int id;
	private String lastName;

	HelloBean(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void printHello() {
		System.out.println("Spring Test: Hello " + firstName + " " + lastName + " with ID= " + id);
	}

	@SuppressWarnings("unused")
	private void init() {
		// TODO Auto-generated method stub
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}
}
