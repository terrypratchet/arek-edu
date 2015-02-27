package com.arek;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringBeanTest {
	private static final String JNDI_NAME =
			"myejb-1.0-SNAPSHOT/StringBean!com.arek.IString";
			//"java:global/myejb-1.0-SNAPSHOT/StringBean";	
	
	private static Context namingContext;
	
	final static Logger logger = LoggerFactory.getLogger(StringBeanTest.class);
	
	private static IString strBean;
	
	public static void main(String[] args) throws NamingException {
		final Properties env = new Properties();

		env.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		env.put(Context.PROVIDER_URL, "remote://localhost:4447");
		
		env.put(Context.SECURITY_PRINCIPAL, "arek");
		env.put(Context.SECURITY_CREDENTIALS, "123");
		
		env.put("jboss.naming.client.ejb.context", true);

		
		namingContext = new InitialContext(env);
		
		try{
		strBean = (IString) namingContext.lookup(JNDI_NAME);
		System.out.println("result: " + strBean.concat("Ar", "ek"));
		testResource();
		testException();
		
		}
		finally{
			namingContext.close();
		}		

	}
	
	private static void testException(){
		try {
			strBean.appException();
		} catch (ArekException e) {
			logger.error(e.getMessage());
			System.out.println("Arek excpetion:" + e.getMessage());
		}/*
		try {
			strBean.runtimeException();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		*/
	}
	
	private static void testResource(){
		System.out.println("pesel: " + strBean.getPesel());
		System.out.println("pesel2: " +strBean.getEnv("pesel"));
		//System.out.println("env: " + strBean.getEnv().size());
	}
	
	static void testAsync(){
		Future<String> resp = strBean.getAsync();
		try {
			resp.get(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
