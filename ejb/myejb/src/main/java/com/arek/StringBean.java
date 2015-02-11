package com.arek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Stateless
public class StringBean implements IString{

	final static Logger logger = LoggerFactory.getLogger(StringBean.class);
	
	@Resource
	private SessionContext context;
	
	@Override
	public String concat(String a, String b) {
		logger.error("returns concat");
		logger.info("test info");
		logger.info("principalName:" + context.getCallerPrincipal().getName());
		IString iString = context.getBusinessObject(IString.class);//this
		iString.say("via buisinessObject");
		return a + b;
	}
	
	@PostConstruct
	public void post(){
		logger.error("I'm in @PostConstruct");
	}
	
	@PreDestroy
	public void preDestroy(){
		logger.error("I'm in @PreDestroy");
	}

	@Override
	public void say(String msg) {
		logger.info(msg);
		
	}

	@Override
	public void appException() throws ArekException{
		throw new ArekException("application exception");
	}

	@Override
	public void runtimeException() {
		throw new IllegalArgumentException("runtimeException");
		
	}

}
