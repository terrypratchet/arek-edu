package com.arek;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class AA{
	abstract protected void a();
}
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

		String arr[] = "boo:and:foo".split("o");
	
		System.out.println("arr:"+Arrays.toString(arr));
		
		
		
		
		
		
		
		
		String s = "4.5x4.a.3";
		String[] tokens = s.split("\\s");
		/*for(String o: tokens)
		System.out.print(o + " ");
		System.out.print(" ");
		*/
		tokens = s.split("\\..");
		
		for(String o: tokens)
		System.out.print("-"+o);
	}

}
