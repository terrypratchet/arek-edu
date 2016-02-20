package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller // could be @Component
public class HomController {

	@RequestMapping(value="/", 	method=GET)
	public String home(){
		return "home"; // view name is home
		/// WEB-INF /views/home.jsp because of you configuration in WebConfig.viewResolver
	}
}
