package com.arek.jaxb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jackson.map.ObjectMapper;

public class Test {
	
	public static Company read(String fileName){
		   try {
			JAXBContext ctx = JAXBContext.newInstance(Company.class);
			   Unmarshaller unMrshaller = ctx.createUnmarshaller();
			   return (Company)unMrshaller.unmarshal(Company.class.getResourceAsStream(fileName));


		   } catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static void test(){
		ObjectMapper mapper = new ObjectMapper();
		//mapper.readValue(content, valueType);
	}
	
	public static Company readJson(String fileName){
		return null;
	}
	
	public static void main(String[] args) {
		Company company = new Company();
		company.setDate(new Date());
		company.printAsXml();

		//TimeZone.setDefault(TimeZone.getTimeZone("GMT+03"));
		
		System.out.println("json:");
		String json = company.printAsJSon();
		
		Company jsonComp=company.readJson( "{\"myDate\":1420620106820}");//"{\"myDate\":1420620106820}"
		System.out.println("jsonComp:" + jsonComp.getMyDate());
		
		Company a = read("a.xml");
		System.out.println("a:" + a.getMyDate());

		
		Company b = read("b.xml");
		System.out.println("b:" + b.getMyDate());
		
	}

}
