package com.arek.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;
//http://localhost:8080/myejb-1.0-SNAPSHOT/ExampleWebService?wsdl
@Stateless
@WebService
public class ExampleWebService {
	
	public void withdraw(@WebParam(name="langCodeArek")String langCode){
		
	}
	public String getName(@WebParam String color, @WebParam( name = "myColor2") String myColor2){
		// color=arg0
		return "hello";
	}
	
	@ResponseWrapper
	public String getName2(){
		return "";
	}
	
	@ResponseWrapper(localName="jakies")
	public String getName3(){
		return "";
	}
	
	
	public List<String> getList(){
		return getC();
	}	
	
	
	@ResponseWrapper
	public List<String> getList2(){
		return getC();
	}
	
	@ResponseWrapper(localName="AJAJA")
	public List<String> getList3(){
		return getC();
	}
	
	@ResponseWrapper(className="NIEMA.TAKIEJ.CLASY")
	public List<String> getList4(){
		return getC();
	}
	
	@ResponseWrapper(className="com.arek.webservice.ArekResponseWrapper")
	public List<String> getList5(){
		return getC();
	}
	
	private List<String> getC(){
		List<String> a = new ArrayList<String>();
		a.add("przyklad");
		return a;
	}
	
	
	/**
	 <ns2:getDtosResponse xmlns:ns2="http://webservice.arek.com/">
         <return>
            <email>arek</email>
            <login>fsdf</login>
         </return>
      </ns2:getDtosResponse>
	 * @return
	 */
	public List<MyDto> getDtos(){
		return createDtos();
	}
	
	
	/**
	 * <ns2:getDtos2Response xmlns:ns2="http://webservice.arek.com/">
       <myResult>
       		<email>arek</email>
	 * @return
	 */
	@WebResult(name="myResult")
	public List<MyDto> getDtos2(){
		return createDtos();
	}

	private List<MyDto> createDtos() {
		MyDto dtos = new MyDto();
		dtos.setEmail("arek");
		dtos.setLogin("fsdf");
		List<MyDto> a = new ArrayList<MyDto>();
		a.add(dtos);
		return a;
	}
	
	
	/**
	 *<ns2:getDtos3Response xmlns:ns2="http://webservice.arek.com/">
         <return>
            <color>green</color>
            <login>fsdf</login>
         </return>
      </ns2:getDtos3Response>
	 * @return
	 */
	public List<MyDto2> getDtos3(){
		MyDto2 dtos = new MyDto2();
		dtos.setColor("green");
		dtos.setLogin("fsdf");
		List<MyDto2> a = new ArrayList<MyDto2>();
		a.add(dtos);
		return a;
	}
	
	/**
	 *
	 <ns2:getDtos4Response xmlns:ns2="http://webservice.arek.com/">
         <myResultDtos4>
            <color>green</color>
            <login>fsdf</login>
         </myResultDtos4>
      </ns2:getDtos4Response>
	 * @return
	 */
	@WebResult(name="myResultDtos4")
	public List<MyDto2> getDtos4(){
		MyDto2 dtos = new MyDto2();
		dtos.setColor("green");
		dtos.setLogin("fsdf");
		List<MyDto2> a = new ArrayList<MyDto2>();
		a.add(dtos);
		return a;
	}
	
	
	/*
	 * <ns2:testVoidResponse xmlns:ns2="http://webservice.arek.com/"/>
	 */
	public void testVoid(){
		
	}
	
	
	/*
	  <ns2:arekResponse xmlns:ns2="http://webservice.arek.com/">
         <return>
            <email>noemail</email>
            <login>nologin</login>
         </return>
      </ns2:arekResponse>
	 */
	@ResponseWrapper(localName="arekResponse", className="com.arek.webservice.MyDtoResponse")
	public MyDto getMyDtoWithWrapper(){
		return new MyDto();
	}
	
	public MyDto getMyDtoWithOutWrapper(){
		return new MyDto();
	}
	
	
	public MyDto3 getXmlElementTest(){
		return new MyDto3();
	}
}
