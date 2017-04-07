package com.arek.jpa.inheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Mammal {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected Long id;
    
    protected String milk;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public Long getLifespan() {
        return lifespan;
    }

    public void setLifespan(Long lifespan) {
        this.lifespan = lifespan;
    }

    protected Long lifespan;
}
