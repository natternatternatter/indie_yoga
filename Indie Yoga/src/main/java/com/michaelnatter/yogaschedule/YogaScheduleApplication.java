package com.michaelnatter.yogaschedule;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripe.Stripe;

@SpringBootApplication
public class YogaScheduleApplication {
	
	@Value("${stripe.api.key}")
	private String stripeApiKey;
	
	@PostConstruct
	public void setup() {
	    Stripe.apiKey = stripeApiKey;

	}

	public static void main(String[] args) {
		SpringApplication.run(YogaScheduleApplication.class, args);
	}

}
