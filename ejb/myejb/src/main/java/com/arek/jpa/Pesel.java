package com.arek.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pesel {
	int value;
	
	@Id
	int peselId;
	
	@OneToOne(mappedBy="pesel") // must be field in Person entity, you can skip this
	Person person;
	
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}



	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
