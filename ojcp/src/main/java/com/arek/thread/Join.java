package com.arek.thread;

public class Join {

	public static void main(String[] args) {
		Thread th = new Thread(){

		};
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
