package java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsJava {

	
	public static void main(String[] args) {
		List<Human> list = Human.generate();
		
		Map<String, List<Human>> g1= list.stream().collect(Collectors.groupingBy(Human::getGender));
	
		g1.forEach( (gender,l)-> System.out.println( gender + ":" + l));
	
	}

}
