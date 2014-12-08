package com.arek.declarations;

class E {
	public int a(){
		return 1;
	}
}

class B extends E{
	@Override
	public int a() throws NullPointerException{ // cannot retunr long!
		return 0;
	}
}
