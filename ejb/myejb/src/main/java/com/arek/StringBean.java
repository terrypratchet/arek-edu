package com.arek;

import java.util.Properties;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Stateless
public class StringBean implements IString{

	final static Logger logger = LoggerFactory.getLogger(StringBean.class);
	
	@Resource
	private SessionContext context;
	
	@Resource
	private String pesel;
	
	
	// use JTA transaction
	@Resource(mappedName = "java:/JmsXA")
	private ConnectionFactory connFactory;

	@Resource(mappedName = "java:/queue/MailToSendQueue")
	private Queue mailQueue;
	
	public String getPesel() {
		return pesel;
	}

	@Override
	public String concat(String a, String b) {
		logger.error("returns concat");
		logger.info("test info");
		logger.info("principalName:" + context.getCallerPrincipal().getName());
		IString iString = context.getBusinessObject(IString.class);//this
		iString.say("via buisinessObject");
		return a + b;
	}
	
	@PostConstruct
	public void post(){
		logger.error("I'm in @PostConstruct");
	}
	
	@PreDestroy
	public void preDestroy(){
		logger.error("I'm in @PreDestroy");
	}

	@Override
	public void say(String smsg)  {
		logger.info(smsg);
		Connection conn = null;

            try {
				conn = connFactory.createConnection();
				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);// let JTA handle transaction
				MessageProducer sender = session.createProducer(mailQueue);
				ObjectMessage msg = session.createObjectMessage();
				msg.setStringProperty("accountName", "");

				sender.send(mailQueue, msg);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             finally{
            	 try {
					conn.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }


		
	}

	@Override
	public void appException() throws ArekException{
		throw new ArekException("application exception");
	}

	@Override
	public void runtimeException() {
		throw new IllegalArgumentException("runtimeException");
		
	}

	@Override
	public Object getEnv(String name) {
		return context.lookup(name);
		
	}

	@Override
	public Properties getEnv() {
		return context.getEnvironment();
	}
	
	@Asynchronous
	@Override
	public Future<String> getAsync() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new AsyncResult<String>("Sukces");
		
	}
	
	
	

}
