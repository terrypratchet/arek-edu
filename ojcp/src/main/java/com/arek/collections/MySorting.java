package com.arek.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySorting {

	public static void main(String[] args) {

		sortNotComparable();

	}

	private static void sortNotComparable() {
		List list = new ArrayList();
		list.add(new Object());
		list.add(new Object());
		Collections.sort(list);
	}

}
