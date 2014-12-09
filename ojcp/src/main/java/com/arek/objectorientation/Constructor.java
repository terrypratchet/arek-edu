package com.arek.objectorientation;

class Vegetable{
	static String s = Constructor.print("Vegetable static variable");
	String f = 		  Constructor.print("Vegetable instance variable");
	Vegetable(){ // cannot be private here (Carrot(String x)) needs this
		Constructor.print("Vegetable constructor");
	}
}
class Carrot extends Vegetable{
	static String s = Constructor.print("Carrot static variable");
	String f = Constructor.print("Carrot instance variable");
	Carrot(){// this()
		this(""); // does not matter
		Constructor.print("Carrot constructor");
	}
	Carrot(String x){};
	void Carrot(){

	}
};

public class Constructor {

	public static String print(String m){
		System.out.println(m);
		return m;

	}
	public static void main(String[] args) {
		new Carrot();



	}

	/*
	 *
	 *
Vegetable static variable
Carrot static variable
Vegetable instance variable
Vegetable constructor
Carrot instance variable
Carrot constructor

	 */

}
