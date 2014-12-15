package com.arek.operators;

public class Logical {

	public static boolean x(String m){
		System.out.println(m);
		return false;
	}
	public static boolean x(String m, boolean b){
		System.out.println(m);
		return b;
	}

	
	public static void main(String[] args) {
		if(  false && true || true){
			System.out.println("hurray");
		}
		
		
		boolean r = x("a") | x("b") & x("c");
		
		System.out.println("=--------");
		boolean r2 = x("a") & x("b") | x("c");

		System.out.println("=--------");
		
		boolean r3 = x("a",false) && x("b",true) || x("c",true);

		

		
	}

}
