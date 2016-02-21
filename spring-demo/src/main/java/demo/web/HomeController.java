package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller // could be @Component
@RequestMapping({"/", "/homepage"})
public class HomeController {

	@RequestMapping(method=GET)
	public String home(){
		return "home"; // view name is home
		/// WEB-INF /views/home.jsp because of you configuration in WebConfig.viewResolver
	}
}
