package com.arek;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RateController {
	
	@Value("${rate}")
	private String rate;
	
	@RequestMapping
	public String getRate(Model model){
		model.addAttribute("rateamount", rate);
		return "rateView";
	}
}


