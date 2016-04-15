package com.arek.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class MyDtoResponse {
	
	@XmlElement(name = "return")
	private MyDto arekarekDto;
}
