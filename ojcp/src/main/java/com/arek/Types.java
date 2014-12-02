package com.arek;

class SubTypes extends Types<Long>{
	
	
	public void hej(Double x){
		super.hej(x);
	}
}


public class Types<S> {

	public <S extends Number>void hej(S s){
		System.out.println( "s:"+s.getClass());
	}
	
	public void hej(Integer s){ // not number
		System.out.println("integer " + s);
	}

	
	public static void main(String[] args) {
		Types<String> types = new Types<String>();
		types.hej(Integer.valueOf(4));

		SubTypes st = new SubTypes();
		st.hej(new Float(4));
		

	}

}