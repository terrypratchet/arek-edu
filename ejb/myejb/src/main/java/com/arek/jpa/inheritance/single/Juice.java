package com.arek.jpa.inheritance.single;

import javax.persistence.Entity;

@Entity
public class Juice extends Food {
    private String fruit;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
    
}
