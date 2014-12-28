package com.arek;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Calendars {
	private Calendar japCal;
	private Calendar buddhistCal;
	private GregorianCalendar gc;

	Locale japaneseLocale;
	
	Calendars() {
	    japaneseLocale = new Locale("ja", "JP", "JP");
		Locale buddhist = new Locale("th", "TH", "TH");

		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,
				japaneseLocale);

		japCal = Calendar.getInstance(japaneseLocale);
		buddhistCal = Calendar.getInstance(buddhist);
		gc = new GregorianCalendar();

	}

	public void test() {
		System.out.println("japanese  date: " + gc.getTime());
		System.out.println("gregorian date: " + japCal.getTime());
		System.out.println("buddhist date: " + buddhistCal.getTime());

		System.out.println("gregorian year:" + gc.get(Calendar.YEAR));
		System.out.println("jap year:" + japCal.get(Calendar.YEAR));
		System.out.println("budd year:" + buddhistCal.get(Calendar.YEAR));

		System.out.println("buddhistCal:" + buddhistCal.getClass().getCanonicalName());
		System.out.println("default cal:" + Calendar.getInstance().getClass().getCanonicalName());
		Locale.setDefault(japaneseLocale);
		System.out.println("default cal:" + Calendar.getInstance().getClass().getCanonicalName());

	}

	public static void main(String[] args) {

		new Calendars().test();

	}

}
