package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.common.Payment;
import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.entiry.Order;
import com.order.repository.OrderRepositry;

@Service
public class OrderService {

	@Autowired
	private OrderRepositry orderRepositry;
	
	@Autowired
	private RestTemplate restTemplate;
 
	private static final String PAYMENT_URL="http://PAYMENT-SERVICE/payment/doPayment";

	public TransactionResponse bookOrder(TransactionRequest transactionRequest) {
		TransactionResponse transactionResponse=new TransactionResponse();
		Order order=transactionRequest.getOrder();
		
		order=orderRepositry.save(order);
		
		Payment payment= transactionRequest.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResponse=restTemplate.postForObject(PAYMENT_URL, payment, Payment.class);
		
		transactionResponse.setTransactionId(paymentResponse.getTransactionId());
		transactionResponse.setAmount(payment.getAmount());
		transactionResponse.setOrder(order);
		return transactionResponse;
	}

	public Order getByOrderId(Integer orderId) {
		 
		return orderRepositry.findById(orderId);
	}
}
