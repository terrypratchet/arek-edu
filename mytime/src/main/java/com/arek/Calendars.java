package com.arek;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import sun.util.BuddhistCalendar;

public class Calendars {
	private Calendar japCal;
	private Calendar buddhistCal;
	private GregorianCalendar gregorian;

	Locale japaneseLocale;
	
	Calendars() {
	    japaneseLocale = new Locale("ja", "JP", "JP");
		Locale buddhist = new Locale("th", "TH", "TH");

		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,
				japaneseLocale);

		japCal = Calendar.getInstance(japaneseLocale);
		buddhistCal = Calendar.getInstance(buddhist);
		gregorian = new GregorianCalendar();

	}

	public void testDifferentCalendars() {
		//gregorian.setTimeZone(TimeZone.getTimeZone("GMT+07"));
		//TimeZone.setDefault(TimeZone.getTimeZone("GMT+07"));
		
		System.out.println("japanese  date: " + gregorian.getTime());
		System.out.println("gregorian date: " + japCal.getTime());
		System.out.println("buddhist  date: " + buddhistCal.getTime());

		
		
		/*
		
		System.out.println("gregorian year:" + gregorian.get(Calendar.YEAR));
		System.out.println("japanese  year:" + japCal.get(Calendar.YEAR));
		System.out.println("budddist  year:" + buddhistCal.get(Calendar.YEAR));

		System.out.println("buddhist cal:" + buddhistCal.getClass().getCanonicalName());
		System.out.println("japanese cal:" + japCal.getClass().getCanonicalName());
		*/
		
		/*
		System.out.println("default  cal:" + Calendar.getInstance().getClass().getCanonicalName());
		Locale.setDefault(japaneseLocale);
		System.out.println("default  cal:" + Calendar.getInstance().getClass().getCanonicalName());
		*/

	}

	private static void testGregorianChange(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setGregorianChange(new Date(Long.MAX_VALUE));
		gc.set(Calendar.YEAR, 1550);
		gc.set(Calendar.MONTH, Calendar.DECEMBER);
		gc.set(Calendar.DAY_OF_MONTH, 24);
		
		System.out.println("after gregorian change: " + gc.getTime());
	}

	
	private static void testStrangeDate(){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setGregorianChange(new Date(Long.MAX_VALUE));
		gc.set(Calendar.YEAR, 1582);
		gc.set(Calendar.MONTH, Calendar.OCTOBER);
		gc.set(Calendar.DAY_OF_MONTH, 5);
		
		System.out.println("not strange date: " + gc.getTime());
	}
	
	
	public static void main(String[] args) {
		new BuddhistCalendar();
		//new Calendars().test();
		//testGregorianChange();
		//testStrangeDate();
		new Calendars().testDifferentCalendars();
	}

}
