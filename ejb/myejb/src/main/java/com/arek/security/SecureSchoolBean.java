package com.arek.security;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeclareRoles({"arek"})
@RolesAllowed(
		{})
@Stateless
@RunAs("admin")
public class SecureSchoolBean implements ISecureSchool{

	final static Logger logger = LoggerFactory.getLogger(SecureSchoolBean.class);

	@Resource
	private SessionContext ctx;
	
	
	@Override
	public void open() {
		logger.info("open " + ctx.getCallerPrincipal().getName() + " " + ctx.isCallerInRole("arek"));
		
		
	}

}