package demo.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
	@Size(min=3, message="{firstName.size}") // ValidationMessages.properties
	@NotNull
	private String firstName;
	private String lastName;
	private String username;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Size(min=3, message="Password too short")
	@NotNull
	private String password;
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
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
