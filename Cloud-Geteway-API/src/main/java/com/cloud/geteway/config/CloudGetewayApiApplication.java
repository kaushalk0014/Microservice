package com.cloud.geteway.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGetewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGetewayApiApplication.class, args);
	}
	
	@Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
       return builder.routes()
      .route("paymentId", r->r.path("/payment/**").uri("http://localhost:9292")) //static routing
      .route("orderId", r->r.path("/order/**").uri("lb://ORDER-SERVICE")) //dynamic routing
      .build();
    }

}
