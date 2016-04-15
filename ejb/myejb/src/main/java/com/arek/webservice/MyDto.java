package com.arek.webservice;

public class MyDto {
	private String login;
	private String email;
	
	public MyDto(){
		this.login="nologin";
		this.email="noemail";
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
