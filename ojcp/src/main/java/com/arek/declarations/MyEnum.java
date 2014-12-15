package com.arek.declarations;

public enum MyEnum {
	PURPLE, WHITE
}

class A{
	
	enum Numbers{
		ONE, TWO,
	}
	public static void main(String[] args){
		System.out.println(MyEnum.WHITE);
		MyEnum en = MyEnum.PURPLE;
		
		switch(en){
		case PURPLE:
			
		}
	}
}
