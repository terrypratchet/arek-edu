package com.arek;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTaks(){
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner{

		@Override
		public void run(String... arg0) throws Exception {
			// TODO Auto-generated method stub
			
			if(null!= arg0){
				System.out.println("Paramenter length:" + arg0.length);
			}
			
		}
		
	}
}
