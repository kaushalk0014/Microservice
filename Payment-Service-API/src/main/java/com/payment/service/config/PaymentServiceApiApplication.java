package com.payment.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {"com.payment.service.entiry"})
@EnableJpaRepositories(basePackages = {"com.payment.service.repositry"})
@ComponentScan(basePackages = {"com.payment.service"})
public class PaymentServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApiApplication.class, args);
	}

}
