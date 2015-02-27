package com.arek;

import java.util.Properties;
import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface IString {
	String concat(String a, String b);
	void say(String msg);
	void appException() throws ArekException;
	void runtimeException();
	String getPesel();
	Object getEnv(String name);
	Properties getEnv();
	Future<String> getAsync();
}
