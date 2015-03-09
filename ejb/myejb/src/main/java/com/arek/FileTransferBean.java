package com.arek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateful ///name=FileTransferBean.EJB_NAME
//@Remote(FileTransferCommonBusiness.class)
public class FileTransferBean implements FileTransferCommonBusiness {

	final static Logger logger = LoggerFactory.getLogger(FileTransferBean.class);
	
	/**
	* Name of the EJB, used in Global JNDI addresses
	*/
	public static final String EJB_NAME = "FileTransferEJB";
	
	
	@Override
	public void mkdir(String directory) throws IllegalStateException {
		logger.error("mkdir");

	}

	@Override
	public void cd(String directory) throws IllegalStateException {
		logger.error("cd " + directory);

	}

	@Override
	public String pwd() throws IllegalStateException {
		logger.error("pwd");
		return null;
	}

	@PrePassivate
	@PreDestroy
	@Override
	public void disconnect() {
		logger.error("disconnect");

	}

	@PostConstruct
	@PostActivate
	@Override
	public void connect() throws IllegalStateException {
		logger.error("connect");

	}

}
