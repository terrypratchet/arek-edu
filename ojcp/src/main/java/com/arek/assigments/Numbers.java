package com.arek.assigments;

public class Numbers {

	public static void main(String[] args) {
		Integer.valueOf("10", 2); // wrapper
		Integer.parseInt("10", 2); // primitive
		new Integer(2).intValue(); // primitive

		Integer i1 = Integer.valueOf(3);// -127 to 128 always cache
		Integer i2 = Integer.valueOf(3);// -127 to 128 always cache

		
		System.out.println(i1.hashCode() + " " + i2.hashCode());
		System.out.println("i1==i2:"+ (i1==i2));
		System.out.println(new Integer(3)== new Integer(3));
		
		
		Integer i3 = 10;
		Integer i4 = 10; // the same
		
		Integer i5 = 1000;
		Integer i6 = 1000; //different
		
		
		System.out.println( "new Integer(5) == 5:" +(new Integer(5) == 5));
		System.out.println( "new Integer(6) == new Integer(6):"+(new Integer(6) == new Integer(6)));
		System.out.println( "7 == new Integer(7):"+ (7 == new Integer(7)));
		System.out.println( "1007 == new Integer(1007):"+ (1007 == new Integer(1007)));
		
		System.out.println("Long.toString(077):" + Long.toString(077));
		System.out.println("Long.toString(3, 2):" + Long.toString(3, 2));
		
		/*
		 * cache:
		 * boolean
		 * byte,
		 * character
		 * short, integer -128 to 127
		 */
		
		Float f = new Float(3);
		Double d = new Double(34);
		
		f.doubleValue();
		d.floatValue();
		d.byteValue();
		
		
	}

}
