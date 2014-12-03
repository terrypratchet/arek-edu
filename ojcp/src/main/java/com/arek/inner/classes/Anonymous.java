package com.arek.inner.classes;

class Wrench{}

public class Anonymous {
	private int inst;

	private void an(){
		final int z=3;
		new Wrench(){
			public void x(){
				System.out.println("inst:" + inst +z);
			}
		}; //notice the semicolon
	}



	public static void main(String[] args) {


	}

}
