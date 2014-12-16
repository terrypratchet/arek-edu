package com.arek;

import java.util.ArrayList;

class Upper{
	static void a(){};
}

class C extends ArrayList{
	Y y;
	void x(){
		Y y;
		new C().removeRange(1, 1);
		//new ArrayList().removeRange(1,1);//not visible
	}
	
	class Y{};
}
public class Inheritance extends Upper{

	void x(){
		System.out.println("");
		super.a();
		
		StringBuilder sb = new StringBuilder();
		
	}
	
	public static void main(String[] args) {
		super.a(); // cannot use super in static context

		assert(false):"" :"";
	}

}
