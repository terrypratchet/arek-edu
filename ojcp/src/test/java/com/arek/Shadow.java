package com.arek;

class A{
	static void a(){}; // cannot be final
	static void b(){};
	void c(){};
	
	final static int e = 4;
	final int f = 3;
	
	final static int g =4;
	final int h = 5;
}

class B extends A{
	static void a(){};
	//void b(){}; // instance method cannot overide static method
	//static void c(){}; //This static method cannot hide the instance method from A

	int e;
	static int f;

	final static int g =4;
	final int h = 5;
}

public class Shadow {

	
	
	public static void main(String[] args) {

	}

}
