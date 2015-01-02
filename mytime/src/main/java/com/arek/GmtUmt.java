package com.arek;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GmtUmt {

	public static void main(String[] args) throws Exception{
		String strDate = "1995-12-31 23:59:60";
		TimeZone gmtTz = TimeZone.getTimeZone("GMT");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		df.setTimeZone(gmtTz);
		Date date = df.parse(strDate);
		System.out.println("date: " + date);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1995);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 60);
		
		System.out.println("cal:"+cal.getTime());
		
		

	}

}
