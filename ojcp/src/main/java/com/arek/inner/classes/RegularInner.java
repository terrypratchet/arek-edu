package com.arek.inner.classes;

public class RegularInner {

	private String id = "3";
	private String x = "outer variable";

	public strictfp final class Hammer{
		static final int z = 3; // must be final
		private String x = "inner variable";
		private void go(String x){
			System.out.println("outer x:" + RegularInner.this.x);
			System.out.println("inner x:" + this.x);
			System.out.println("argument x:" + x);
		}
	}
	private void createInnerInstance(){
		new Hammer();
		
		
		final class Hammer{ void x(){} };
		//class RegularInner{}; // compile error
	}


	public static void main(String[] args) {
		//new Hammer(); // compliation errror;
		RegularInner r = new RegularInner();
		//r.Hammer h4; // won't compile

		Hammer h = r.new Hammer();
		RegularInner.Hammer h2;

		h.go("argument");
	}

}
