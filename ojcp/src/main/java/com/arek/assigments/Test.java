package com.arek.assigments;

public class Test {


	public static void main(String[] args) {
		int x = 'a'; // ''-compile error
		System.out.println("x:" +x);
		byte b = (byte)500; // cast needed
		int zero = 000000000;
		int octal = 03423;
		int hed = 0x0000DeadCafe;
		char letterN = '\u004E';
		char c = 982;
		System.out.println("zero:" + zero);
		//char minus = -4; //compile error
		
		byte myByte =0;
		myByte++; // implicit cast
		//myByte = myByte + myByte; //compile error
		
		int castDouble = (int)2.9;
		System.out.println("castDouble: " + castDouble);
		
		int arek;
		if(false){
			System.out.println(arek);
		}
		
		Byte wrappedByte = new Byte("23");
		Long longa = new Long(3);
		
		Float floata = new Float("3f");
		System.out.println("floata: " + floata);
		
		if(new Boolean(true)){ // won't compile using 1.4 or earlier
			
		}
		int i=0;
		for(int i=0; ;){};
		
	}

}
