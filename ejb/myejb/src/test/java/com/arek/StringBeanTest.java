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
		namingContext = ArekContext.getNamingContext();
		
		try{
		strBean = (IString) namingContext.lookup(JNDI_NAME);
		
		
		//strBean.say("dfsdf");
		System.out.println("result: " + strBean.concat("Ar", "ek"));
		/*
		System.out.println("result: " + strBean.concat("Ar", "ek"));
		testResource();
		testException();
		testAsync();
		*/
		
		
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
		String text = null;
		try {
			text = resp.get(10, TimeUnit.SECONDS);
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
		System.out.println("response from async: " + text);
	}

}
