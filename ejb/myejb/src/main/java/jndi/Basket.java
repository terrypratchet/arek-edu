package jndi;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class Basket implements IBasket{
	final static Logger logger = LoggerFactory.getLogger(Basket.class);

	@Resource
	private SessionContext ejbContext;
	
	@Resource(name="ciphersPassphrase")
	private String passphrase = "defaultPassphrase";
	
	@EJB
	private IApricot apricot;
	
	@PostConstruct
	public void load(){
		logger.info("---------- loaded basket");
		apricot.hello();
		
		IGrape grape = (IGrape) ejbContext.lookup("java:global/myejb-1.0-SNAPSHOT/Grape!jndi.IGrape");
		grape.hello();
		
		IPear pear = (IPear) ejbContext.lookup("java:app/myejb-1.0-SNAPSHOT/myPear");
		pear.hello();
		
		try {
			InitialContext jndiContext = new InitialContext( );
			String pesel = (String) jndiContext.lookup("java:comp/env/pesel");
			logger.info("pesel: " + pesel);
			logger.info("passphrase:" + passphrase);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
}
