package com.arek.inner.classes;
class Spanner{};

public class Hiding {
	private void m(){
		Spanner a= new Spanner();
		
		class Spanner{};
		
		Spanner b = new Spanner();
		
		System.out.println(a.getClass().getCanonicalName());

		System.out.println(b.getClass().getCanonicalName());
	}
	
	public static void main(String[] args){
		new Hiding().m();
	}
}
