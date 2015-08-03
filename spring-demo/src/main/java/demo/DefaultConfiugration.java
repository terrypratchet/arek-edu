package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import demo.synonims.Benjamins;
import demo.synonims.Dough;
import demo.synonims.Money;

@Configuration
@ComponentScan
public class DefaultConfiugration {

	@Profile("dev")
	@Bean
	public Money createGeneral(){
		return new Dough();
	}
	
	@Profile("prod")
	@Bean
	public Money create100$(){
		return new Benjamins();
	}
}
