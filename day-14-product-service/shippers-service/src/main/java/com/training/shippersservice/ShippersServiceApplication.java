package com.training.shippersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShippersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippersServiceApplication.class, args);
	}

}
