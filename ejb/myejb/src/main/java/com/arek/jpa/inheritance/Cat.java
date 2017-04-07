package com.arek.jpa.inheritance;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="cat_primary_key_join_column") // default id
public class Cat extends Mammal{
    private Long tailLength;

    public Long getTailLength() {
        return tailLength;
    }

    public void setTailLength(Long tailLength) {
        this.tailLength = tailLength;
    }
    
}
