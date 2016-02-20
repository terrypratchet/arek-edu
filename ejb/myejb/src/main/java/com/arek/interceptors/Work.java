package com.arek.interceptors;

import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Interceptors(Auditor.class)
public class Work implements IWork{
	final static Logger logger = LoggerFactory.getLogger(Work.class);
	
	@Interceptors(Auditor.class)
	@Override
	public void lunch() {
		logger.info("lunch....................");
		
	}
	
	@AroundInvoke
	public Object beanClassInterceptor(InvocationContext ctx){
		logger.info("beanClassInterceptor...................." + ctx.getMethod().getName());
		try {
			return ctx.proceed();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

}
