package jndi;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless(name="myPear")
public class Pear implements IPear{
	final static Logger logger = LoggerFactory.getLogger(Pear.class);

	@Override
	public void hello() {
		logger.info("I'm a pear");
		
	}
}
