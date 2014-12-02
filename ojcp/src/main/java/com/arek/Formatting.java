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
			System.out.println(nf.parse("2,5"));
			System.out.println(nf.parse("2.56are"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
