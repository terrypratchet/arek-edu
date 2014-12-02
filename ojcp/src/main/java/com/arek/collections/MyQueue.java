package com.arek.collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyQueue {

	public static void main(String[] args) {
		Queue queue = new PriorityQueue();
		queue.add("c");
		queue.add("b");
		queue.add("a");
		for(Object o : queue){
			System.out.println("element:" + o);
		}

		Iterator it = queue.iterator();
		while(it.hasNext()){
			System.out.println("it: " + it.next());
		}


		while(!queue.isEmpty()){
			System.out.println("poll:" + queue.poll());
		}



	}

}
