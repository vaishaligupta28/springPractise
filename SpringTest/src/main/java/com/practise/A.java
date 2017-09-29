package com.practise;

public class A {
	B b;
	A() {
		System.out.println("A() creating......");
	}
	
	A(B b){
		System.out.println("Cons injection");
		this.b = b;
	}
	public B getB() {
		System.out.println("setter injection");
		return b;
	}

	public void setB(B b) {
		System.out.println("setter injection-------");
		this.b = b;
	}
	void printA()
	{
		System.out.println("hello A");
	}
	
	void display()
	{
		printA();
		b.printB();	
	}
}
