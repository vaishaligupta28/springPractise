package com.practise;

public class C {
	D d;
	C() {
		System.out.println("C() creating......");
	}
	
	C(D d){
		System.out.println("using parameterized constructor type autowiring");
		this.d = d;
	}

	public D getD() {
		System.out.println("setter injection");
		return d;
	}

	public void setD(D d) {
		this.d = d;
	}
	void printC()
	{
		System.out.println("hello C");
	}
	
	void display()
	{
		printC();
		d.printD();
		
	}
}
