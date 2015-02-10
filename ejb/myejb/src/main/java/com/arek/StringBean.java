package com.arek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Stateless
public class StringBean implements IString{

	final static Logger logger = LoggerFactory.getLogger(StringBean.class);
	
	@Override
	public String concat(String a, String b) {
		logger.error("returns concat");
		logger.info("test info");
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

}
