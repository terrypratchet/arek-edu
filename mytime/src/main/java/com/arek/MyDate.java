package com.arek;

import java.sql.ResultSet;
import java.util.Date;

public class MyDate {

	public static void main(String[] args) throws Exception{
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		System.out.println("date: " + date);
		new Date().toString();
		
		ResultSet rs = null; rs.getDate(0);

	}

}
