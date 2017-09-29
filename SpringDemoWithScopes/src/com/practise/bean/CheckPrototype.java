package com.practise.bean;

public class CheckPrototype {
	private String name;
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getMessage() {
		System.out.println(name + " "+message);
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
