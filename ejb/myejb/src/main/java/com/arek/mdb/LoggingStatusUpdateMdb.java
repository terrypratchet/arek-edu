package com.arek.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = StatusUpdateConstants.TYPE_DESTINATION_STATUSUPDATE),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = StatusUpdateConstants.JNDI_NAME_TOPIC_STATUSUPDATE) })

@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class LoggingStatusUpdateMdb implements MessageListener {
	
	final static Logger logger = LoggerFactory.getLogger(LoggingStatusUpdateMdb.class);

	public static enum ACTIONS  { SystemException, ApplicationException, NoneException};
	public static String ACTION_PROPERTY = "action";
	public void onMessage(Message message) {
		try {
			String strAction = message.getStringProperty(ACTION_PROPERTY);
			logger.info("received message " + strAction);
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ACTIONS action = ACTIONS.valueOf(strAction);
			switch(action){
			case SystemException:
				throw new NullPointerException();
			case ApplicationException:
				break;
			
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
