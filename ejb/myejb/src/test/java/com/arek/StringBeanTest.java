package com.arek;

import java.util.Properties;

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

}
