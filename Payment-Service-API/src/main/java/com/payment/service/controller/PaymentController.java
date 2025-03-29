package com.payment.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.service.entiry.Payment;
import com.payment.service.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	//http://localhost:9292/payment/doPayment
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/doPayment")
	public ResponseEntity<Payment> doPayment(@RequestBody Payment payment){
		
		payment=paymentService.doPayment(payment);
		
		return  new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}
}
