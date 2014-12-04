package com.arek.thread;

public class Synchronizing {

	synchronized void waitForMe() throws InterruptedException{
		System.out.println("waiting...");
		wait();
		System.out.println("stop waiting.");
	}
	public static void main(String[] args) {
		Synchronizing s = new Synchronizing();
		try {
			s.waitForMe();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
