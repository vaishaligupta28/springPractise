package com.practise.di;

public class ConsInjectInheritingBean {
	private int id;
	private String name;
	private Address address;
	
	public ConsInjectInheritingBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ConsInjectInheritingBean(int id, String name, Address address){
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public void display() {
		System.out.println("ConsInjectInheritingBean \n\nid=" + id + "\nname=" + name + "\n"+ address);;
	}
}
