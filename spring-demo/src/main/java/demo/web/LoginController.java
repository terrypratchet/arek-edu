package demo.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(method=GET)
	public String login(){
		return "login";
	}
}
