package com.github.InvestApp.CreditCardService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class CreditCardServiceClientApplication {


	public static void main(String[] args) {

		SpringApplication.run(CreditCardServiceClientApplication.class, args);

	}
	@GetMapping("/")
	public Mono<String> hello()
	{
		return Mono.just("Hello World");
	}

	@GetMapping("/welcome")
	public Mono<String> welcome()
	{
		return Mono.just("Welcome to Credit Card Service");
	}

}
