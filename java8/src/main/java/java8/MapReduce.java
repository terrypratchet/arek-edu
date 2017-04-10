package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduce {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2);
		List<Integer> list2 = Arrays.asList(8,9,10);
		List<Integer> list3 = Arrays.asList(50);
		

		List<List<Integer>> list = Arrays.asList(list1, list2, list3);
	
		System.out.println( list);
		
		list.stream().map(l->l.size())
		.forEach(System.out::println);
		
		System.out.println("=------");
		
		list.stream()
			.flatMap(l->l.stream())
			.forEach(System.out::println);
		
		
		// reductions are terminated operations
		
		List<Integer> ints = Arrays.asList(4,5);
		
		Integer result = ints.stream()
			.reduce(1, Integer::sum);
		
		System.out.println("reduce sum: " + result);
		
		Optional<Integer> max = ints.stream()
				.reduce(Integer::max);
		
		System.out.println("max:" + max.get());
		
		// reduction seen as an aggregation
		
	}

}
