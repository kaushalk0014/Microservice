package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	//http://localhost:9191/order/bookOrder
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public ResponseEntity<TransactionResponse> bookOrder(@RequestBody TransactionRequest transactionRequest){
		
		TransactionResponse transactionResponse=orderService.bookOrder(transactionRequest);
		return new ResponseEntity<TransactionResponse>(transactionResponse, HttpStatus.OK);
	}
}
