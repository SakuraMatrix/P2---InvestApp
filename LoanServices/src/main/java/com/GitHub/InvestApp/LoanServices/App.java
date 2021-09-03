package com.GitHub.InvestApp.LoanServices;


import com.GitHub.InvestApp.LoanServices.controller.LoanController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableEurekaClient
public class App {
	private @Autowired
	LoanController controller;

	@Value("${server.port}")
	private String port;
	//@Autowired
	//private LoanController controller;
//	private static final Logger log = LoggerFactory.getLogger("GUI");

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	@Bean
	public HttpServer httpServer(ApplicationContext context) {
		HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
		return HttpServer.create().port(Integer.parseInt(port)).handle(adapter);
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
