package com.arek;

import java.sql.ResultSet;

public class MyDate {

	public static void main(String[] args) throws Exception{
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		System.out.println("date: " + date);
		
		
		ResultSet rs = null; rs.getDate(0);

	}

}
