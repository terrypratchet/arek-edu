package com.arek.thread;

public class Lock {

	private String lock = "";

	class A extends Thread{

		@Override
		public void run(){
			synchronized(lock){
				System.out.println("czekam...");
				try {
					//boolean a= true;while(a){a=a|true; if(!a)throw new InterruptedException();};
					lock.wait(10000);
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

		try{Thread.sleep(2000);} catch(Exception e){};
		System.out.println("drugi start..");
		 testLock.new A().start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}Thread.yield();

		synchronized(testLock.lock){System.out.println("poobudka1");
			testLock.lock.notify();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized(testLock.lock){System.out.println("pobudka");
			testLock.lock.notify();
		}

	}

}
