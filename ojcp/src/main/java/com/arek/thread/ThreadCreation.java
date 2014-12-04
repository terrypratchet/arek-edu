package com.arek.thread;

public class ThreadCreation {
	
	

	public static void main(String[] args) {
		Thread th = new Thread(){
			public void run(){
				System.out.println("empty constructor");
			}
		};
		Thread th2 = new Thread("Arek"){
			public void run(){
				System.out.println("String constructor");
			}
		};
		
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("runnable");
			}
		};
		
		Thread th3 = new Thread(r);
		Thread th4 = new Thread(r, "nazwany");
		
		th.start();
		th2.start();
		th3.start();
		th4.start();
		th4.start();
		

	}

}
