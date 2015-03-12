package com.arek;

import java.net.URL;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class RssCacheBean implements IRssCacheBean{
	final static Logger logger = LoggerFactory.getLogger(RssCacheBean.class);
	
	@Lock(LockType.READ)
	public URL getUrl(){
		logger.info("getUrl");
		return null;
	}

	@PostConstruct
	@Lock(LockType.WRITE) //// Optional metadata, WRITE is the default
	@Override
	public void refresh() {
		logger.info("refresh");
	}
}
