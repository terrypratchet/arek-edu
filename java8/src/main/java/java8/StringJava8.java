package java8;

import java.util.StringJoiner;

public class StringJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello world";
		
		
		StringJoiner sj = new StringJoiner(",").add("one").add("to");
		System.out.println("sj: " + sj);

		StringJoiner sj2 = new StringJoiner(",",  "{",  "}").add("one").add("to");
		System.out.println("sj2: " + sj2);

		
		System.out.println(String.join(",", "Arkadiusz", "Wanda"));
	}

}
