package com.arek.jaxb;

import java.util.Date;
import java.util.GregorianCalendar;

public class IcalTest {

    private static Date setDateInGMTTimeZone(Date date) {
        java.util.Calendar dateInGMTTimeZone = new GregorianCalendar();
        dateInGMTTimeZone.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
        dateInGMTTimeZone.setTimeInMillis(date.getTime());
        return dateInGMTTimeZone.getTime();
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		Date nDate = setDateInGMTTimeZone(date);
		System.out.println("nDate:"+ nDate);
		
		date.getTimezoneOffset();
	}

}
