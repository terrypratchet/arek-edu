package com.arek.interceptors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class Start {

	@EJB
	private IWork work;

	@PostConstruct
	public void init() {
		work.lunch();
	}
}
