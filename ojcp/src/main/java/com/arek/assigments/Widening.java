package com.arek.assigments;

public class Widening {

	static void x(double x){
		System.out.println("double");
	}
	
	static void y(float y){
		System.out.println("float");
	}
	
	static void y2(long y){
		System.out.println("long");
	}
	
	
	public static void main(String[] args) {
		x((byte) 3);
		y( (byte)4);

	}

}
