package jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Memory {
	public static void main(String[] args){
		test2();
		
		
	}

	private static void test() {
		Person p = new Person();
		WeakReference<Person> wr = new WeakReference<Person>(p);
		// A weak reference, simply put, is a reference that isn't strong enough to force an object to remain in memory.
		
		p=null;
		System.gc();
		
		Person p2 = wr.get();
		
		System.out.println( "p2:" + p2);
		
		//  WeakHashMap class.WeakHashMap works exactly like HashMap, except that the keys (not the values!) are referred to using weak references. If a WeakHashMap key becomes garbage, its entry is removed automatically
		// SoftReferences aren't required to behave any differently than WeakReferences, but in practice softly reachable objects are generally retained as long as memory is in plentiful supply
	}
	
	private static void test2() {
		Person p = new Person();
		
		ReferenceQueue<Person> rq = new ReferenceQueue<Person>();
		
		WeakReference<Person> wr = new WeakReference<Person>(p,rq);
		// A weak reference, simply put, is a reference that isn't strong enough to force an object to remain in memory.
		
		System.out.println("before gc: " + rq.poll());
		
		p=null;
		
		//System.out.println("before gc: " + rq.poll());
		System.gc();
		System.out.println("after gc: " + rq.poll());
		
		Person p2 = wr.get();
		
		System.out.println( "p2:" + p2);
		
		//  WeakHashMap class.WeakHashMap works exactly like HashMap, except that the keys (not the values!) are referred to using weak references. If a WeakHashMap key becomes garbage, its entry is removed automatically
		// SoftReferences aren't required to behave any differently than WeakReferences, but in practice softly reachable objects are generally retained as long as memory is in plentiful supply
	}

	
}
