package com.arek.assigments;

class A{
	public void finalize(){
		System.out.println("finalize");
	}
}

public class Boxing {

	static void a(int a){};
	static void b(Integer b){};
	
	static void c(char zupa){};
	
	public static void main(String[] args) {
		int all =3;
		
		//
		
		short sh = 3;
		char dfs;
		byte myByte=3;
		
		
		a(myByte);
		char a2 = 'd';
		a(a2);
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
		
		byte ii=1;
		short c = ii;
		
	}	

}
