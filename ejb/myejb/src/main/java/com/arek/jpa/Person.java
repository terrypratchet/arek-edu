package com.arek.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

@Entity
public class Person {
	@Id
	private int id;
	
	@ElementCollection(targetClass=String.class) // targetClass only when generic type is not used (value)
	@CollectionTable(name="default_is_Person_someMap") // not needed
	@MapKeyColumn(name="default_is_someMap_KEY") // not needed
	@Column(name="default_is_someMap") // not needed, refers to value column
	private Map<String, String> someMap = new HashMap<String,String>();
	
	private Job job; // no error when Job is annotated with @Embeddable

	public Map<String, String> getSomeMap() {
		return someMap;
	}

	public void setSomeMap(Map<String, String> someMap) {
		this.someMap = someMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String firstName;
	private String lastName;

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
