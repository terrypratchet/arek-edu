package com.arek.sessionBeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
@DependsOn("Starter34234")
/**
 * The container ensures that all Singleton beans with which a Singleton has a DependsOn
	relationship have been initialized before PostConstruct is called.
	
	This shows the use of the fully-qualified ejb-name syntax to refer to a Singleton component packaged
within a different module in the same application:
	@DependsOn(“b.jar#B”)
 */


/**
 * By default, a singleton bean has container managed concurrency demarcation if the concurrency man-
agement type is not specified
 *
 */
@Lock(LockType.READ)
public class SingletonToTest {

	@PostConstruct
	public void init(){
		
	}
	
	@PreDestroy
	public void toDestroy(){
		
	}
	
	
	@Lock(LockType.WRITE)
	public void writeMethod(){
		
	}
	
	/**
	 * An @AccessTimeout value of 0 indicates that concurrent access is not allowed. Access attempts on
	methods with a timeout value of 0 result in a javax.ejb.ConcurrentAccessException.
	 */
	
	/**
	 * An @AccessTimeout value of -1 indicates that the client request will block indefinitely until forward
		progress can be made.
	 */
}
