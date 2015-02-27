package com.arek;

import java.util.Properties;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Stateless
public class StringBean implements IString{

	final static Logger logger = LoggerFactory.getLogger(StringBean.class);
	
	@Resource
	private SessionContext context;
	
	@Resource
	private String pesel;
	
	
	public String getPesel() {
		return pesel;
	}

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

	@Override
	public Object getEnv(String name) {
		return context.lookup(name);
		
	}

	@Override
	public Properties getEnv() {
		return context.getEnvironment();
	}
	
	@Asynchronous
	@Override
	public Future<String> getAsync() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new AsyncResult<String>("Sukces");
		
	}
	
	
	

}
