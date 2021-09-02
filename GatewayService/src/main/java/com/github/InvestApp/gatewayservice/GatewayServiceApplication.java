package com.github.InvestApp.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayServiceApplication.class, args);
  }

//  @Bean
//  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//    return builder
//        .routes()
//        .route(p -> p.path("/account").uri("lb://AccountService"))
//        .route(p -> p.path("/analysis").uri("lb://AnalysisService"))
//        .route(p -> p.path("/cards").uri("lb://CreditCardService"))
//        .route(p -> p.path("/loans").uri("lb://LoanService"))
//        .route(p -> p.path("/").uri("lb://ClientService"))
//        .build();
//  }
}
