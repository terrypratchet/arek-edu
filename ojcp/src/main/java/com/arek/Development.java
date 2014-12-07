package com.arek;

import java.util.Arrays;
import java.util.Properties;

public class Development {

	public static void main(String[] args) {
		Properties props = System.getProperties();
		props.list(System.out);
		
		System.out.println("args:" + Arrays.toString(args));
		;
		
	}

}
