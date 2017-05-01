package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class CollectionApi {

	public static void main(String[] args) {
		List<String> mylist = Arrays.asList("Arek", "Toman");
		mylist.parallelStream();
		
		Spliterator<String> spliterator = mylist.spliterator();
		
		mylist.forEach(System.out::println);
		
		
		Collection<String> coll = mylist;
		
		Collection<String> list = new ArrayList(coll);
		list.removeIf(a->a.length()>10);
		
		System.out.println(list.stream().collect(Collectors.joining(",")));

		mylist.replaceAll(t-> t+2);

		System.out.println(mylist.stream().collect(Collectors.joining(",")));
		
		mylist.sort(Comparator.naturalOrder());
		
	}

}
