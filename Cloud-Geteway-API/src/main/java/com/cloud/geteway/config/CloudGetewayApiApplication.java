package com.cloud.geteway.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.cloud.geteway.controller" })
public class CloudGetewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGetewayApiApplication.class, args);
	}

	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				// .route("paymentId", r->r.path("/payment/**").uri("http://localhost:9292"))
				// //static routing
				.route("paymentId", r -> r.path("/payment/**")
						.filters(f -> f.circuitBreaker(
								config -> config.setName("paymetServiceCB").setFallbackUri("forward:/paymentFallback")))
						.uri("lb://PAYMENT-SERVICE"))
				.route("orderId", r -> r.path("/order/**")
						.filters(f -> f.circuitBreaker(
								config -> config.setName("orderServiceCB").setFallbackUri("forward:/orderFallback")))
						.uri("lb://ORDER-SERVICE"))
				.build();
	}

}
