package jndi;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class Grape implements IGrape{
	final static Logger logger = LoggerFactory.getLogger(Grape.class);

	@Override
	public void hello() {
		logger.info("I'm grape");
		
	}
}
