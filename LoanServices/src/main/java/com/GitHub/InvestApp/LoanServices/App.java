package com.GitHub.InvestApp.LoanServices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class App {

	private static final Logger log = LoggerFactory.getLogger("GUI");

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/hello")
	public Mono<String> hello(){
		log.info("Hello world testing loaded" );
		return Mono.just("Hello and Welcome to the Financial Loans Department");
	}

	/**
	 * A REST End point to the HTML GUI
	 *  endPoint: ""
	 **/
	@GetMapping("loans")
	public void addViewControllers(ViewControllerRegistry registry) {
		log.info("Loading GUI interface" );
	}
}
