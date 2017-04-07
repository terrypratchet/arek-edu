package com.arek.jpa;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
/*
 * A class designated as a mapped superclass has no separate table defined for it. Its mapping information
is applied to the entities that inherit from it.

A mapped superclass, unlike an entity, is not queryable and must not be passed as an argument to
EntityManager or Query operations. Persistent relationships defined by a mapped superclass must
be unidirectional.

A class designated as a mapped superclass has no separate table defined for it. Its mapping information
is applied to the entities that inherit from it.
 */
@MappedSuperclass
public class Employee {
	@Id
	protected  long empId;
	
	protected String firstName;
	protected String lastName;
	
	@ManyToOne
	@JoinColumn(name="my_address_id") // default address_someId
	protected Address address;
	
	
	public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
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
	
	
	
	
}
