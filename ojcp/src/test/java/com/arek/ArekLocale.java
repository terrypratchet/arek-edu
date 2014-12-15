package com.arek;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class ArekLocale {
	//final String s; // error
	
	public static void main(String[]args){
		Locale l = new Locale("pl", "UKf");
		DateFormat df = DateFormat.getInstance();
		Date date = new Date();
		System.out.println("getInstance:" + df.format(date));


		DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL, l);
		System.out.println("locale:" + dfl.format(date));
		d(new Integer(4));
		
		String x = null;
		Object o = x;
		Integer i = (Integer) o;
		
		
		for(i = 0, o=null; i < 3; i++, System.out.print("howdy ")) ;
		
	}
	
	static void d(int dx){};
	
	
}
