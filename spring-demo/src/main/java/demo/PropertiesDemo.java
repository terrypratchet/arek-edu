package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import demo.synonims.Money;

public class PropertiesDemo {

	@Autowired
	Money money;
	
	@Autowired
	Color color;
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(PropertiesDemo.class, args);

	}

}
