package com.arek;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@Controller
public class RateController {
	
	@Value("${rate}")
	private String rate;

	@Value("${secret}")
	private String secret;
	
	@RequestMapping
	public String getRate(Model model){
		model.addAttribute("rateamount", rate);
		model.addAttribute("secret", secret);

		return "rateView";
	}
}


