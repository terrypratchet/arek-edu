package com.arek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroserviceApplication {

	@RequestMapping
	public String hej(){
		return "sukces";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
}
