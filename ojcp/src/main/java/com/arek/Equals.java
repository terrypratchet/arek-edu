package com.arek;

public class Equals {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("a");
		System.out.println( "stringBuilde equlas:" + s.equals(new StringBuilder("a")));

		StringBuffer buffer = new StringBuffer("z");
		System.out.println("stringBuffer equals:" + new StringBuffer("z").equals(buffer));

		System.out.println("Integer equlas primitive type" + new Integer(3).equals(3));

		System.out.println("Long integer:" + new Long(3).equals(3));
		System.out.println("Long Long:" + new Long(3).equals(3L));

		System.out.println("Double double: " + new Double(4.0).equals(4.0));

	}

}
