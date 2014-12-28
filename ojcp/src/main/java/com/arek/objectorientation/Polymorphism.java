package com.arek.objectorientation;

import java.io.FileNotFoundException;

class Fruit{
	String name =" fruit";
	Number eat() throws FileNotFoundException{
		return null;
	}
	static void x(){};
	
	int i(){return 3;};
};

class Plum extends Fruit{
	String name = "Plum";
	@Override
	public Integer eat() throws NullPointerException{
		return null;
	}
	static void x(){};
	//byte i(){return 3;};
}

abstract interface Iarek{
	
}


public class Polymorphism {



	public static void main(String[] args) {
		Fruit fruit = new Plum();
		System.out.println("name: " + fruit.name);

	}

}
