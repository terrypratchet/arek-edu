package com.arek.jpa.lifecycle;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@EntityListeners(com.arek.jpa.lifecycle.AlertMonitor.class)

public class World {
    Long id;
    String name;
    
    @Transient
    Logger log = LoggerFactory.getLogger(World.class);

    Integer arekVersion;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
    @Version
    public Integer getArekVersion() {
        return arekVersion;
    }
    public void setArekVersion(Integer arekVersion) {
        this.arekVersion = arekVersion;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    @PrePersist
    public void prePersst(){
        log.info("prePersist");
    }
    
    @PostPersist
    public void postPersist(){
        log.info("postPersist");
    }
    
    @PreUpdate
    public void preUpdate(){
        log.info("preUpdate");
    }
    
    @PostUpdate
    public void postUpdate(){
        log.info("postUpdate");
    }
    
    @PreRemove
    public void preRemove(){
        log.info("preRemove");
    }
    
    @PostRemove
    protected  void postRemove(){
        log.info("postRemove");
        
    }
    
    @PostLoad
    void postLoad(){
        log.info("postLoad");
    }
}
