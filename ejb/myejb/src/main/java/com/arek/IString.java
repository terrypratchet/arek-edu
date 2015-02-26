package com.arek;

import javax.ejb.Remote;

@Remote
public interface IString {
	String concat(String a, String b);
	void say(String msg);
	void appException() throws ArekException;
	void runtimeException();
	String getPesel();
}
