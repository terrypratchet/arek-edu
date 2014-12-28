package com.arek.inheritance;

class Z{
	String x = "Z super var";
	
	void test(){
		System.out.println("sa: " + say() + "   " + x);
	}
	
	 String say(){
		return "Z super";
	}
}


public class A extends Z{
	String x = "z A sub var";
	
	String say(){
		return "A sub";
	}

	

public static void main(String arg[]){
	new A().test();
}

}

