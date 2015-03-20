package com.arek.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(
	    name = "MailToSendQueue",
	    activationConfig = {
	        @ActivationConfigProperty( propertyName ="destinationType",
	                                   propertyValue="javax.jms.Queue" ),

	        @ActivationConfigProperty( propertyName ="destination",
	                                   propertyValue="queue/MailToSendQueue" ),

	        @ActivationConfigProperty( propertyName ="acknowledgeMode",
	                                   propertyValue="Auto-acknowledge" ),
			//see note next to @PoolClass annotation below
	        @ActivationConfigProperty( propertyName="maxSession",
	                                   propertyValue="5")
	    }
)


public class ArekQueue implements MessageListener {
	final static Logger logger = LoggerFactory.getLogger(ArekQueue.class);

	public void onMessage(Message message) {
		logger.info("received message");

	}

}
