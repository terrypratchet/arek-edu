package com.arek.declarations;

class E<T> {
	public int a(){
		return 1;
	}
	public E e(){
		return null;
	}
}

class B extends E{
	@Override
	public int a() throws NullPointerException{ // cannot retunr long or byte!
		return 0;
	}
}
