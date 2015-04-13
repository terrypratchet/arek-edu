package com.arek.interceptors;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Interceptors(Auditor.class)
public class Work implements IWork{
	final static Logger logger = LoggerFactory.getLogger(Work.class);
	

	@Override
	public void lunch() {
		logger.info("lunch....................");
		
	}

}
