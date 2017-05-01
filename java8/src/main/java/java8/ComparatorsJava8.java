package java8;

import java.util.Comparator;

public class ComparatorsJava8 {
	private class Person{
		String firstName;
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		String lastName;
	}
	
	public static void main(String[] args) {
		
		new Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				return 0;
			}
			
		};
		
		Comparator<Person> compareLastName = Comparator.comparing(Person::getLastName)
				.thenComparing(Person::getFirstName)
				.reversed();
		
		Comparator.nullsFirst(Comparator.naturalOrder());

	}

}
