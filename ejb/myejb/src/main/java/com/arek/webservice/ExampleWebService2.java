package com.arek.webservice;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Stateless
@WebService
public class ExampleWebService2 extends ExampleWebService{
	
	@WebMethod(exclude=true)
	public void withdraw(String langCode){
		
	}
	@WebMethod
	public void withdraw(){
		
	}
}
