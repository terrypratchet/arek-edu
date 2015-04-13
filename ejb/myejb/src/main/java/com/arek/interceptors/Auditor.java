package com.arek.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Auditor {
	final static Logger logger = LoggerFactory.getLogger(Auditor.class);
	
	@AroundInvoke
	public Object audit(final InvocationContext context) throws Exception{
		logger.info("before proceeding...");
		Object o =  context.proceed();
		logger.info("after proceeding.");
		return o;
	}
}
