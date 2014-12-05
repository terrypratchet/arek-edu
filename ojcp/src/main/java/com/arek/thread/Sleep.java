package com.arek.thread;

public class Sleep {

	public static void main(String[] args) {
		Thread th = new Thread(){
			@Override
			public void run(){
				try {
					Thread.sleep(3600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		th.start();

		th.interrupt();


	}

}
