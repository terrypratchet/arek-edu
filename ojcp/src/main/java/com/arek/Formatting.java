package com.arek;

import java.text.NumberFormat;
import java.text.ParseException;

public class Formatting {

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getInstance();

		System.out.println("max fraction:" + nf.getMinimumFractionDigits());
		System.out.println("min fraction:" + nf.getMinimumFractionDigits());

		//nf.setMinimumFractionDigits(4);
		//nf.setMaximumFractionDigits(4);

		try {
			System.out.println(nf.format(4.5f));
			System.out.println(nf.parse("2,5a"));
			System.out.println(nf.parse("2,96are"));

			nf.setMaximumFractionDigits(2);

			nf.setMinimumFractionDigits(2);
			System.out.println(nf.parse("2,89999999999999"));
			System.out.println("nf.format(1/3):" + nf.format(10/3));
			System.out.println("" + nf.format(2.126));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
