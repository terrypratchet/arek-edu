package jndi;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class Apricot implements IApricot{
	
	final static Logger logger = LoggerFactory.getLogger(Apricot.class);
	
	@Override
	public void hello() {
		logger.info("I'm apricot");
	}

}
