package com.arek.collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class MyTreeMap {

	public static void main(String[] args) {
		TreeMap tMap = new TreeMap();
		tMap.put("a", 1);
		tMap.put("z", 13);
		tMap.put("b", 2);

		SortedMap head = tMap.headMap("b");
		System.out.println( head.keySet() );
		SortedMap tail = tMap.tailMap("b");
		


	}

}
