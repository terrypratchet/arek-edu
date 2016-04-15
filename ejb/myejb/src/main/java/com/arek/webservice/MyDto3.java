package com.arek.webservice;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class MyDto3 {
	
	private String heniek2 = "henik2"; // jest
	
	private String heniek3 = "heniek 3"; // jest
	
	@XmlElement(name="questionsAnswered")
	private String heniek = "jak to?"; // jest
	
	
	public String getHeniek2() { // jest
		return heniek2;
	}


	public String getTenNiedziala(){ // nie ma
		return "ten nie dziala";
	}
	
	
	private List<String> list1 = Arrays.asList("standard");
	
	@XmlElementWrapper(name="owijacz")
	private List<String> list2 = Arrays.asList("wrapper");
	
	
	
	/*
	 *          
      <ns2:getXmlElementTestResponse xmlns:ns2="http://webservice.arek.com/">
         <return>
            <heniek2>henik2</heniek2>
            <heniek3>heniek 3</heniek3>
            <questionsAnswered>jak to?</questionsAnswered>
            <list1>standard</list1>
            <owijacz>
               <list2>wrapper</list2>
            </owijacz>
         </return>
      </ns2:getXmlElementTestResponse>

	 */
	
	
	private List<MyDto> listDtos1 = Arrays.asList(new MyDto());
	
	@XmlElementWrapper(name="owijaczDto")
	private List<MyDto> listDtos2 = Arrays.asList(new MyDto());
	
	/*
	 *  
            <listDtos1>
               <email>noemail</email>
               <login>nologin</login>
            </listDtos1>
            <owijaczDto>
               <listDtos2>
                  <email>noemail</email>
                  <login>nologin</login>
               </listDtos2>
            </owijaczDto>
	 */
	
	
}
