package com.arek.objectorientation;

import java.io.FileNotFoundException;

class Fruit{
	String name =" fruit";
	Number eat() throws FileNotFoundException{
		return null;
	}
	static void x(){};
};

class Plum extends Fruit{
	String name = "Plum";
	@Override
	public Integer eat() throws NullPointerException{
		return null;
	}
	static void x(){};

}


public class Polymorphism {



	public static void main(String[] args) {
		Fruit fruit = new Plum();
		System.out.println("name: " + fruit.name);

	}

}
