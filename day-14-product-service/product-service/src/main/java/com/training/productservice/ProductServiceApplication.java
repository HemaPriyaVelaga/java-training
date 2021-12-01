package com.training.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


// THis instructs spring to auto instantiat and load objects (beans) of components
// Component class is annotated with @Component, @Service, @Repository, @Controller, @Configuration
// Component scan is done only for the classes that exist inside com.training or any of its sub packages

@EnableEurekaClient
@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
// By default, it uses H2 database. If it is not available, throws error
// To use some other database, go to application.yml
// and add datasource