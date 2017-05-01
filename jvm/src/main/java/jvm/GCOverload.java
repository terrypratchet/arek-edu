package jvm;

import java.util.Random;

public class GCOverload {

	public static void main(String[] args) {
		int s = 1000000;
		Long[] list = new Long[s];
		Random r = new Random();
		
		while(true){
			int index = r.nextInt(s);
			list[index] = r.nextLong();
			System.gc();
		}

	}

}
