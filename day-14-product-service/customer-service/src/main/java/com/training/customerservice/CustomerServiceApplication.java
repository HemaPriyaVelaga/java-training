package com.training.customerservice;

import com.training.customerservice.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2 // Starts building the API docs (JSON) by using the docket bean defined below
public class CustomerServiceApplication {

	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(path -> path.startsWith("/api/"))
				.apis(RequestHandlerSelectors.basePackage("com.training"))
				.build();
		// The swagger beans loaded via pom.xml dependencies will invoke this function
		// In order for an object of this class to be instantiated and kept in the container
		// use @Bean annotation
	}
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	// Check this link : http://localhost:9091/actuator
}
