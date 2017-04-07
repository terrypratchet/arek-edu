package com.arek.jpa;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverride(name="address", joinColumns=@JoinColumn(name="manager_adddress_id"))
@AttributeOverride(name="firstName", column = @Column(name="mangerFirstName"))
public class Manager extends Employee {
	private String salary;

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
}
