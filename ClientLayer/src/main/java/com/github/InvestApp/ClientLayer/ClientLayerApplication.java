package com.github.InvestApp.ClientLayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientLayerApplication.class, args);
	}
}
