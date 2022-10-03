package com.michaelnatter.yogaschedule.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@Value("${stripe.public.key}")
	private String stripePublicKey;

	@GetMapping("/classes/make_payment")
	public String home(Model model) {
		model.addAttribute("stripePublicKey", stripePublicKey);
		return "payment_form.jsp";
	}
	
	@GetMapping("/thankYou")
	private String thankYou() {
		return "thank_you.jsp";
	}
}