package com.arek.webservice;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="arekDTO")
public class MyDto2 {
	private String login;
	private String color;
	
	public List<MyDto> getMydtolist() {
		;
		return Arrays.asList(new MyDto());
	}
	public void setMydtolist(List<MyDto> mydtolist) {
		this.mydtolist = mydtolist;
	}
	private List<MyDto> mydtolist;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
