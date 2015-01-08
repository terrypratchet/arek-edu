package com.arek.jaxb;

import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@XmlRootElement
public class Company {
	
	
	
	@XmlElement
	
	private Date myDate;
	
	


	@JsonProperty("myDate")
	public Date getMyDate(){
		return myDate;
	}

	public void setDate(Date date){
		this.myDate = date;
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
	
	
	public String printAsJSon(){
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(this);
			System.out.println("json:" + json);
			return json;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Company readJson(String json){
		System.out.println("json to read: " + json);
		ObjectMapper mapper = new ObjectMapper();
		//mapper.readValue(jp, valueType)
		
			try {
				JSONParser jsonParser = new JSONParser();
				jsonParser.parse(json);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		return null;
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