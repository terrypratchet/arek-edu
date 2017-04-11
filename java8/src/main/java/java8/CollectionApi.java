package java8;

import java.util.Arrays;

public class CollectionApi {

	public static void main(String[] args) {
		Arrays.asList("Arek", "Toman").parallelStream();
		
		Arrays.asList("Arek", "Toman").spliterator();

	}

}
