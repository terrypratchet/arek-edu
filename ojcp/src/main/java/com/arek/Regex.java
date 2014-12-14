package com.arek;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	
	static void regex(String input, String regex){
		System.out.println("" + input + " " + regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while(m.find()){
			System.out.println(m.group() +" " + m.start() +"," + m.end());
		}
	}
	public static void main(String[] args) {
		regex("boo:and:foo", "o");

		String arr[] = "boo:and:foo".split("o", 1);
	
		System.out.println(""+Arrays.toString(arr));
	}

}
