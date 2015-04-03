package com.arek.security;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeclareRoles({"arek"})
@RolesAllowed(
		{})
//@Stateless
public class SecureSchoolBean implements ISecureSchool{

	final static Logger logger = LoggerFactory.getLogger(SecureSchoolBean.class);

	@Override
	public void open() {
		logger.info("open");
		
	}

}