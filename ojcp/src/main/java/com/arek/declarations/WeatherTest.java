package com.arek.declarations;

public class WeatherTest {

	static Weather w = Weather.Sunny.RAINY.Sunny;

	public static void main(String[] args) {
		System.out.println(w.RAINY);
		System.out.print(w.RAINY.count + " " + w.Sunny.count + " ");
		System.out.println(w.RAINY);
	}
}

enum Weather {
	RAINY, Sunny;
	public  int count = 0;

	Weather() {
		System.out.print("c " );
		count++;
	}
}