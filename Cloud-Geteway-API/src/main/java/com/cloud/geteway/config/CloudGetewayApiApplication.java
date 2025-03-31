package com.cloud.geteway.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGetewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGetewayApiApplication.class, args);
	}

}
