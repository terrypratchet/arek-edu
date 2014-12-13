package com.arek.flow;

public class Test {

	public static void main(String[] args) {
		byte b = 13;
		switch(new Byte(b)){
		//case 128: // cannot convert from int to byte
		case 2:
			break;
		case 3:{}
		default: System.out.println("default");
		case 5: System.out.println("5"); break;
		case 6 : System.out.println("6"); 
		
		
		}
		
		
		String s;
		
		String[] w = {""};
		
		for(String a:w){// s:w won't compile 
			
		}
		
		
		arek:
		{System.out.println("Arek"); };
		
		cud:
		for(;;){
			continue cud;
			// continue arek; // label arek is missing
		}
		

		

		

	}
	
	void empty(){
		for(;;){
			return;
		}
	}

}
