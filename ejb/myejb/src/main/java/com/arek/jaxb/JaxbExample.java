package com.arek.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class JaxbExample {
	
	class MySchemaOutputResolver extends SchemaOutputResolver {
		String baseDir = "/tmp";
	    public Result createOutput( String namespaceUri, String suggestedFileName ) throws IOException {
	        return new StreamResult(new File(baseDir,suggestedFileName));
	    }
	}
	
	@XmlRootElement(name="heja")
	public static class Arek{
		
		private String jobName="fsdf";
		
		public String getJobName() {
			return jobName;
		}

		public void setJobName(String jobName) {
			this.jobName = jobName;
		}

		//@XmlElement
		public String getFirstName(){
			return "Arkadiusz";
		}
		
		public String getLasttName(){
			return "Toman";
		}
	}
	
	
	public  static void main(String[] args) throws JAXBException{
		JaxbExample je = new JaxbExample();
		Arek arek = new Arek();
		JAXBContext jaxbContext = JAXBContext.newInstance(Arek.class);
		Marshaller m = jaxbContext.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(arek, System.out);
		
	}
}
