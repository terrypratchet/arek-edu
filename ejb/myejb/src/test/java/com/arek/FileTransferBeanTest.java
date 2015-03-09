package com.arek;

import javax.naming.Context;
import javax.naming.NamingException;

public class FileTransferBeanTest {
	private static final String EJB_NAME = "myejb-1.0-SNAPSHOT/FileTransferBean!com.arek.FileTransferCommonBusiness";
	private static Context namingContext;
	
	public static void main(String[] args) throws NamingException {
		namingContext = ArekContext.getNamingContext();
		Object obj = namingContext.lookup(EJB_NAME);
		FileTransferCommonBusiness ftp = (FileTransferCommonBusiness) obj;
		ftp.cd("/home");
	}
}
