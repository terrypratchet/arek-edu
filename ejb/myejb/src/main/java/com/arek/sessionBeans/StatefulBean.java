package com.arek.sessionBeans;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * A timeout value of -1 indicates that the bean must not be removed due to timeout for as long as 
 * the application is deployed
 * A timeout value of 0 indicates that the bean is immediately eligible for removal after
	becoming idle
	If a stateful session bean timeout is not designated using this standard metadata, the container determines
	 when to end the lifetime of the bean, possibly based on vendor-specific configuration
	 
	A stateful session bean instance is not eligible for timeout while it is associated with a transaction or while it is processing a business method or callback 
 */
@StatefulTimeout(unit=TimeUnit.SECONDS, value=30)
@Stateful
public class StatefulBean {
	final static Logger logger = LoggerFactory.getLogger(StatefulBean.class);
	
	@PostConstruct
	public void helloPostConstruct(){
		logger.info("hello - @PostConstruct");
	}
	
	@PostActivate
	public void helloPostActivation(){
		logger.info("hello - @PostActivation");
	}
	
	
	
	// SessionSynchronization notifications.
	
	/**
		The afterBegin notification signals a session bean instance that a new transaction has begun. The
		container invokes this method before the first business method within a transaction (which is not necessarily
		at the beginning of the transaction). The afterBegin notification is invoked with the transaction context.
		The instance may do any database work it requires within the scope of the transaction.
		afterBegin occurs before any AroundInvoke method invocation
	 */
	@AfterBegin
	public void afterBegin(){
		logger.info("hello - @AfterBegin");
	}
	
	
	/**
	    The beforeCompletion notification is issued when a session bean instance’s client has completed
		work on its current transaction but prior to committing the resource managers used by the instance. At
		this time, the instance should write out any database updates it has cached. The instance can cause the
		transaction to roll back by invoking the setRollbackOnly method on its session context.
		beforeCompletion after all AroundInvoke
	 */
	@BeforeCompletion
	protected void beforeCompletion(){
		logger.info("hello - @BeforeCompletion");
	}
	
	/** 
		The afterCompletion notification signals that the current transaction has completed. A completion
		status of true indicates that the transaction has committed. A status of false indicates that a rollback
		has occurred. Since a session bean instance’s conversational state is not transactional, it may need to
		manually reset its state if a rollback occurred.
	 */
	@AfterCompletion
	private void afterCompletion(){
		logger.info("hello - @AfterCompletion");
	}
	
	// A session synchronization method must not be declared as final or static.
	
	/*
		There is no need for a session bean with bean-managed transaction demarcation to rely on the synchro-
		nization call backs because the bean is in control of the commit—the bean knows when the transaction
		is about to be committed and it knows the outcome of the transaction commit.
	 */
	
	
	// -----------------------------
	
	/**
	 * Invocation of the remove method causes the removal of the stateful session bean after the remove
		method successfully completes
		
		If the Remove annotation specifies the value of retainIfException as true,
		 and the Remove method throws an application exception, the instance is not removed.
	 */
	@Remove
	public void remove(){
		logger.info("_____remove");
	}
	
	
	public void someMethod(){
		logger.info("hello some method");
	}
	
}
