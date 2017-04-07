package com.arek.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    private int someId;
    
    private String street;

    public int getSomeId() {
        return someId;
    }

    public void setSomeId(int someId) {
        this.someId = someId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
