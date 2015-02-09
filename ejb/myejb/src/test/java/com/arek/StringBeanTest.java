package com.arek;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StringBeanTest {
	private static final String JNDI_NAME =
			"myejb-1.0-SNAPSHOT/StringBean!com.arek.IString";
			//"java:global/myejb-1.0-SNAPSHOT/StringBean";	
	
	private static Context namingContext;
	
	private static IString strBean;
	
	public static void main(String[] args) throws NamingException {
		final Properties env = new Properties();
		//env.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());

		env.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		env.put(Context.PROVIDER_URL, "remote://localhost:4447");
		
		env.put(Context.SECURITY_PRINCIPAL, "arek");
		env.put(Context.SECURITY_CREDENTIALS, "123");
		
		env.put("jboss.naming.client.ejb.context", true);
		//arek
		//123
		
		namingContext = new InitialContext(env);
		
		try{
		strBean = (IString) namingContext.lookup(JNDI_NAME);
		System.out.println("result: " + strBean.concat("Ar", "ek"));
		}
		finally{
			namingContext.close();
		}
		

	}

}
