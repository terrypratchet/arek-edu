package com.arek.assigments;

class A{
	public void finalize(){
		System.out.println("finalize");
	}
}

public class Boxing {

	static void a(int a){};
	static void b(Integer b){};
	

	
	public static void main(String[] args) {
		a(new Integer(7));
		b(7);
		A a = new A();
		a.finalize();
		a = null;
		System.out.println("...");
		for( int i =0; i<100000; i++){
			new StringBuilder("dfsdf");
		}
		System.gc();
	}	

}
