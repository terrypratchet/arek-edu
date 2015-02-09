package com.arek;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
public class StringBean implements IString{

	@Override
	public String concat(String a, String b) {
		return a + b;
	}

}
