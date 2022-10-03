package com.michaelnatter.yogaschedule.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michaelnatter.yogaschedule.dto.CreatePayment;
import com.michaelnatter.yogaschedule.dto.CreatePaymentResponse;
import com.michaelnatter.yogaschedule.models.Course;
import com.michaelnatter.yogaschedule.models.Instructor;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
public class PaymentController {


	
	@PostMapping ("/create-payment-intent")
	public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
			
		    PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
		    	.setCurrency("usd")
		        .setAmount(15 * 100L)
		        .build();

		      // Create a PaymentIntent with the order amount and currency
		    PaymentIntent intent = PaymentIntent.create(createParams);
		    return new CreatePaymentResponse(intent.getClientSecret());
	}
	
}