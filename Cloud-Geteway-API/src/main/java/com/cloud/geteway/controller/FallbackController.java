package com.cloud.geteway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/orderFallback")
	public Mono<String> orderServiceFallback(){
		return Mono.just("Order service taking too long to response or is down, Please check some time");
	}
	
	@RequestMapping("/paymentFallback")
	public Mono<String> paymentServiceFallback(){
		return Mono.just("Payment service taking too long to response or is down, Please check some time");
	}
}
