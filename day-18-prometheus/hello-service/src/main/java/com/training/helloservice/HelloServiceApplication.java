package com.training.helloservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Slf4j
@SpringBootApplication
public class HelloServiceApplication {

	@GetMapping(path = "/api/hello", produces = "application/json")
	public Map<String, Object> handleGetHelloMessage(
			@RequestParam(required = false, defaultValue = "friend") String name
	)
	{
		log.debug("Got Request Parameter name as " + name);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("timestamp", new Date());
		map.put("success", true);
		map.put("message", String.format("Hello, %s", name));

		log.debug("Returning the map as {}", map);
		return map;
	}
	public static void main(String[] args) {
		log.debug("Starting HelloServiceApplication-day-18");
		SpringApplication.run(HelloServiceApplication.class, args);
		log.debug("HelloServiceApplication-day-18 started!");

	}

}
