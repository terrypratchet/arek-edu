package com.arek.flow;

public class Exceptions {

	static void f(){
		try{
			System.out.println("try");
			int x=3/0;
		}
		catch(Exception e){
			System.out.println("exc");
			return;
		}
		finally{
			System.out.println("finally");
		}
	}
	static void f2(){
		try{
			int x=3/0;
		}
		finally{
			System.out.println("finally2");
		}
	}
	public static void main(String[] args) {
		f();
		try{
		f2();
		}
		catch(Exception e){System.out.println("caaught");};
		
		System.out.println("end");
		
	}

}
