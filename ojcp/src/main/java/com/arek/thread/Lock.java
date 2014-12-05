package com.arek.thread;

public class Lock {

	private String lock = "";

	class A extends Thread{

		@Override
		public void run(){
			synchronized(lock){
				System.out.println("czekam...");
				try {
					lock.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("skonczyhlem");

			}
		}
	}

	class B extends Thread{
		@Override
		public void run(){

		}
	}

	public static void main(String[] args) {
		Lock testLock = new Lock();
		A a = testLock.new A();
		a.start();


		 testLock.new A().start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized(testLock.lock){
			testLock.lock.notify();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized(testLock.lock){
			testLock.lock.notify();
		}

	}

}
