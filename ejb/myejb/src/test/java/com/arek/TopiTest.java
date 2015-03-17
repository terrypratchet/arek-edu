package com.arek;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.NamingException;

public class TopiTest {
	public static void main(String args[]) throws NamingException, JMSException{
		Context namingContext = ArekContext.getNamingContext();
		// Get the queue from JNDI
		final Topic topic = (Topic) namingContext.lookup("jndiNameOfTargetTopic");
		// Get the ConnectionFactory from JNDI
		final TopicConnectionFactory factory = (TopicConnectionFactory) namingContext
		.lookup("jndiNameOfConnectionFactory");
		
		// Make a Connection
		final TopicConnection connection = factory.createTopicConnection();
		final TopicSession sendSession = connection.createTopicSession(false,
		TopicSession.AUTO_ACKNOWLEDGE);
		final TopicPublisher publisher = sendSession.createPublisher(topic);
		// Make the message
		final Message message = sendSession.createTextMessage();
		// Publish the message
		publisher.publish(message);
		//log.info("Published message " + message + " with contents: " + status);
		// Clean up
		sendSession.close();
		connection.close();
		}

	
}
