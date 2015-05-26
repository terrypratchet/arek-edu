package com.arek.sessionBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
public class Starter34234 {
	final static Logger logger = LoggerFactory.getLogger(Starter34234.class);
	
	@EJB
	StatefulBean st;
	
	
	@PostConstruct
	public void start(){
		st.someMethod();
	}
	
	
	
}
