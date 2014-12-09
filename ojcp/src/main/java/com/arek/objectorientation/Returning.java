package com.arek.objectorientation;

public class Returning {

	public int foo() {
		char c = 'c';
		return c; // char is compatible with int
	}


	public Object getObject() {
		int[] nums = {1,2,3};
		return nums; // Return an int array,
		// which is still an object
	}

	private long getLong(){
		int i=0;
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
