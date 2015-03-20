package com.arek;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ArekContext {
	public static Context getNamingContext() throws NamingException {
		final Properties env = new Properties();

		env.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		env.put(Context.PROVIDER_URL, "remote://localhost:4447");
		
		env.put(Context.SECURITY_PRINCIPAL, "arek");
		env.put(Context.SECURITY_CREDENTIALS, "123");
		
		env.put("jboss.naming.client.ejb.context", true);
		
		//env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");

		
		return new InitialContext(env);
	}
}
