package com.arek.thread;

public class Sync {
	String name;
	Sync(String name){
		this.name = Thread.currentThread().getId() + "";
	}
    synchronized void x(){
	  System.out.println( name + " x czekam");
	  sleep(3000);
	  y();
	  System.out.println( name + " x gotowe" );
	}

    synchronized void y(){
  	  System.out.println( name + " y robie");
  	  sleep(1000);
  	  
  	}
    
    void sleep(long l){
    	try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Sync s = new Sync("Arek");
		
		Thread th = new Thread(){
			public void run(){
				s.x();
			}
		}
		;
		

		Thread th2 = new Thread(){
			public void run(){
				s.x();
			}
		};
		

		th.start();

		th2.start();
		

	}

}
