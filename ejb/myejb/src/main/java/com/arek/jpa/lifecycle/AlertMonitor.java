package com.arek.jpa.lifecycle;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertMonitor {
   
    Logger log = LoggerFactory.getLogger(AlertMonitor.class);
    
    /*
     * Lifecycle callback methods may throw unchecked/runtime exceptions. A runtime exception
thrown by a callback method that executes within a transaction causes that transaction to be
marked for rollback.
• Lifecycle callbacks can invoke JNDI, JDBC, JMS, and enterprise beans.
• In general, the lifecycle method of a portable application should not invoke EntityMan-
ager or Query operations, access other entity instances, or modify relationships within the
same persistence context. [43] A lifecycle callback method may modify the non-relationship
state of the entity on which it is invoked.
     */

    
    /*
     * These database operations may occur directly after
the persist, merge, or remove operations have been invoked or they may occur directly after a flush
operation has occurred (which may be at the end of the transaction).
     */
    
    @PrePersist
    public void prePersst(World world){
        log.info("prePersist " + world.getName());
    }
    
    @PostPersist
    public void postPersist(World world){
        log.info("postPersist " + world.getName());
    }
    
    
    /*
     * Note that it is implementation-dependent as to whether PreUpdate and PostUpdate call-
backs occur when an entity is persisted and subsequently modified in a single transaction or
when an entity is modified and subsequently removed within a single transaction. Portable
applications should not rely on such behavior.
     */
    @PreUpdate
    public void preUpdate(World world){
        log.info("preUpdate " + world.getName());
    }
    
    @PostUpdate
    public void postUpdate(World world){
        log.info("postUpdate " + world.getName());
    }
    
    @PreRemove
    public void preRemove(World world){
        log.info("preRemove " + world.getName());
    }
    
    @PostRemove
    protected  void postRemove(World world){
        log.info("postRemove " + world.getName());
        
    }
    
    /*
     * The PostLoad
method is invoked before a query result is returned or accessed or before an association is traversed
     */
    
    @PostLoad
    void postLoad(World world){
        log.info("postLoad " + world.getName());
    }

    /*
     * It is implementation-dependent as to whether callback methods are invoked before or after the cascad-
ing of the lifecycle events to related entities.
     */
    
    
    /*
     * Default listeners, if any, are invoked first, in the order specified in the XML descriptor. Default listeners
apply to all entities in the persistence unit, unless explicitly excluded by means of the ExcludeDe-
faultListeners annotation or exclude-default-listeners XML element.

     */
    
    /*
     * If multiple classes in an inheritance hierarchy—entity classes and/or mapped superclasses—define
entity listeners, the listeners defined for a superclass are invoked before the listeners defined for its sub-
classes in this order. The ExcludeSuperclassListeners annotation or exclude-super-
class-listeners XML element may be applied to an entity class or mapped superclass to exclude
the invocation

The excluded listeners are excluded from the class to which the ExcludeSuper-
classListeners annotation or element has been specified and its subclasses.
     */
    
    /*
     * A class is
permitted to override an inherited callback method of the same callback type, and in this case, the over-
ridden method is not invoked.
     */
    
}
