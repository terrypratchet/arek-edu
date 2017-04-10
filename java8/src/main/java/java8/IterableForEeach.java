package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IterableForEeach {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("raz", "dwa");
		Consumer<String> c = System.out::println;
		
		list.forEach(System.out::println);

		list.forEach(c.andThen(c));

	}
	

}
