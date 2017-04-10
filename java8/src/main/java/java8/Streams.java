package java8;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Arek", "Toman", "hej");
		
		Predicate p2 = Predicate.isEqual("hej");
		Predicate p3 = Predicate.isEqual("so");
		
		p2.and(p3);
		
		stream
			.filter(s->s.length()>3) /// the call to  the filter is lazy
			.forEach(s->System.out.println("OLD"+ s)) // final operation
			;

		Stream.of("Arek", "Toman", "hej")
		// intermediary operation
			.peek(System.out::println) // returns stream
			.filter(s-> true)
			.forEach(s->System.out.println("New"+ s));
			;
		
	}

}
