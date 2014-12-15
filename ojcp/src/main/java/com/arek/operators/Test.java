package com.arek.operators;

public class Test {

	enum Country{ France, Poland}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		x *= 2 + 5;
		System.out.println("x *= 2 + 5:" + x);
		
		
		Country c1 = Country.France;
		Country c2 = Country.France;

		System.out.println("c1==c2: " + (c1==c2));
		System.out.println( "c1.equals(c2):" + ( c1.equals(c2)));
		
		Integer i = 3;
		Object o = new Object();

		
		//boolean b = (i instanceof String); // compile error
	
		boolean b2 = (o instanceof String[]);
		boolean b3 = null instanceof String;
		
		
		System.out.println("3 % 2 = " + (3 % 2));

		System.out.println("-3 % 2 = " + (-3 % 2));

		System.out.println("3 % -2 = " + (3 % -2));

		System.out.println("-3 % -2 = " + (-3 % -2));

		System.out.println("3.1 % 2 = " + (3.1 % 2));
		
		System.out.println( 2 + 7 + "" + 9);
		
		System.out.println("" + (       3<2?"Arek":"Arkadiusz"   ));

		System.out.println("3==3.0f" + ( 3==3.0f ));
		
		Integer[] i1 = {1};
		Integer[] i2 = {1};
		System.out.println("i1==i2" + (i1==i2));
		
	}
	

}
