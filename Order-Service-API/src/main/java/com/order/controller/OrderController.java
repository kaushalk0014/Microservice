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
import com.order.entiry.Order;
import com.order.service.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/order")
public class OrderController {

	//http://localhost:9191/order/bookOrder
	//http://localhost:9191/order/getById/1
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public ResponseEntity<TransactionResponse> bookOrder(@RequestBody TransactionRequest transactionRequest){
		
		TransactionResponse transactionResponse=orderService.bookOrder(transactionRequest);
		return new ResponseEntity<TransactionResponse>(transactionResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Order> getByOrderId(@RequestParam  Integer orderId) {
		Order order= orderService.getByOrderId(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
}
