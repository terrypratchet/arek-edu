package java8;

import java.util.HashMap;
import java.util.Map;

public class MapJava8 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.getOrDefault("hhhhhda", 3);

		map.put("dfs", 3); // erase an existing value
		map.putIfAbsent("fds", 3);
		map.replace("dfsd", 33);
		
		map.put("Arek", 13);
		
		map.compute("Arek", (a,b)-> 50);
		
		map.remove("Arek");
		map.merge("Arek", 3, (a,b)-> 52);
		
		System.out.println("Arek: " + map.get("Arek"));
	}

}
