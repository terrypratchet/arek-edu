package com.arek.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrays {

	public static void main(String[] args) {
		asList();
		List list = new ArrayList();
		list.add("1");
		list.add("2");

		Object[] array = list.toArray();

		list.add("3");

		System.out.println("array: " + Arrays.toString(array));

	}

	private static void asList() {
		String[] arr = {"Arek", "Sun" };
		List list = Arrays.asList(arr);
		//list.add("Zupa");
		list.set(0, "New");
		list.add("oj");

		System.out.println("array:"+ Arrays.toString(arr));

		arr[1] = arr[1] + " a to ciekawe";

		System.out.println("list: " + list);
	}

}
