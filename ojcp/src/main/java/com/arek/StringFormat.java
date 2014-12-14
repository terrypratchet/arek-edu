package com.arek;

import java.io.Console;

public class StringFormat {

	public static void main(String[] args) {
		
		
		System.out.println(String.format("%d", 4));

		System.out.println(String.format("%d", 8)); // could not be float!
		System.out.println(String.format("%f", 4.1)); // colud not be int!
		System.out.println(String.format("%f", 4.1f)); // colud not be int!
		System.out.println(String.format("%f", new Float(3.f))); // colud not be int!

		System.out.println(String.format("%+d", 8)); // could not be float!
		System.out.println(String.format("%2$+d", 1,2,3)); // could not be float!
	
		System.out.println(new Integer(27).equals(27));
		System.out.println(new Long(3).equals(3));
	
		
		java.io.Console  c= System.console();
		char[] zupa = c.readPassword();
	
		System.out.println("haslo:"+ zupa);
	}

}
