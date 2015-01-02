package com.arek.jaxb;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Company {
	
	
	
	@XmlElement
	private Date date;
	
	



	public Date getMyDate(){
		return date;
	}

	public void setDate(Date date){
		this.date = date;
	}
	public void printAsXml() {
	    try {
	        JAXBContext ctx = JAXBContext.newInstance(Company.class);
	        Marshaller marshaller = ctx.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        marshaller.marshal(this, System.out);
	    }
	    catch (Exception
	            e) {
	    	e.printStackTrace();
	              //catch exception 
	    }
	}
	

	
	
	




	
	public static void main(String[] args){
		Company company = new Company();

		company.setDate(new Date());

		/*
		company.toXml();
		
		company.read();
		
		System.out.println("json: " + company.toJSonString());
		//System.out.println("json date: " + company.readFromJson().getMyDate());
		*/
		//System.out.println("json date by jackson: " + company.readFromJsonByJackson().getMyDate());

	}
}


/*
http://wiki.fasterxml.com/JacksonFAQDateHandling
*/