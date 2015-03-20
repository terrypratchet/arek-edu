package com.arek.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = StatusUpdateConstants.TYPE_DESTINATION_STATUSUPDATE),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = StatusUpdateConstants.JNDI_NAME_TOPIC_STATUSUPDATE) })
public class LoggingStatusUpdateMdb implements MessageListener {
	
	final static Logger logger = LoggerFactory.getLogger(LoggingStatusUpdateMdb.class);

	public void onMessage(Message message) {
		logger.info("received message");

	}
}
