package jndi;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class Basket implements IBasket{
	final static Logger logger = LoggerFactory.getLogger(Basket.class);

	@EJB
	private IApricot apricot;
	
	@PostConstruct
	public void load(){
		logger.info("---------- loaded basket");
		apricot.hello();
	}
	
}
