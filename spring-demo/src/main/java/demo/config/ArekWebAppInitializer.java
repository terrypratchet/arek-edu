package demo.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ArekWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer
		/*
		 * This abastract class registers automatically DispatcherServlet and 
		 * LoaderListener
		 */
		{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
	registration.setMultipartConfig(
	new MultipartConfigElement("/tmp/spittr/uploads"));
	}

}
