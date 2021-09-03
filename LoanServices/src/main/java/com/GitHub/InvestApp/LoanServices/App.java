package com.GitHub.InvestApp.LoanServices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableEurekaClient
public class App {
	//@Autowired
	//private LoanController controller;
//	private static final Logger log = LoggerFactory.getLogger("GUI");

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

//	@GetMapping("/hello")
//	public Mono<String> hello(){
//		log.info("Hello world testing loaded" );
//		return Mono.just("Hello and Welcome to the Financial Loans Department");
//	}
//
//	/**
//	 * A REST End point to the HTML GUI
//	 *  endPoint: ""
//	 **/
//	@GetMapping("api/v0.1/loans")
//	public void addViewControllers(ViewControllerRegistry registry) {
//		log.info("Loading GUI interface" );
//	}
}
