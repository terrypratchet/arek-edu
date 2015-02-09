package com.arek;

import javax.ejb.Remote;

@Remote
public interface IString {
	String concat(String a, String b);
}
