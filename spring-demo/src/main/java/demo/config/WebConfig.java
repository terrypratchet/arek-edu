package demo.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
// enable spring mvc
@ComponentScan("demo.web")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	
	// configure a jsp view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	// configure static content hadnling
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();

	}
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
	return new StandardServletMultipartResolver();
	}
	
	/*
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
	
	@Bean
	public ViewResolver viewResolver2() {
	return new TilesViewResolver();
	}
	*/
	
}
