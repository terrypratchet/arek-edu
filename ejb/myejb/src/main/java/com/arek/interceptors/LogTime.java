package com.arek.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTime {
	final static Logger logger = LoggerFactory.getLogger(LogTime.class);
	
	@AroundInvoke
	public Object audit(final InvocationContext context) throws Exception{
		long startTime = System.currentTimeMillis();
		Object o =  context.proceed();
		long endTime = System.currentTimeMillis();
		
		long duration = endTime - startTime;
		logger.info("Total mehtod time " + duration + "ms for method " + context.getMethod().getName() );
		return o;
	}
}
