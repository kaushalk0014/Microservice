package com.payment.service.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.service.entiry.Payment;
import com.payment.service.repositry.PaymentRepositry;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepositry repositry;

	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return repositry.save(payment);
	}
	
	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}
}
