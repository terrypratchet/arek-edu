package java8;

import java.util.ArrayList;
import java.util.List;

public class Human {
	String name;
	String lastName;
	
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	String gender;
	Integer age;
	
	public Human(String name, String lastName, String gender, Integer age){
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}
	
	public static List<Human> generate(){
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("Arek", "Toman", "m", 33));
		humans.add(new Human("Zuza", "FNF", "f", 18));
		humans.add(new Human("Nikola", "Toman", "f", 33));
		humans.add(new Human("Henryk", "Wielki", "m", 18));
		humans.add(new Human("Sto", "Lat", "m", 100));
		
		return humans;
	}
}
