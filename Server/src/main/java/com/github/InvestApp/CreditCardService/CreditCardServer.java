package com.github.InvestApp.CreditCardService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class CreditCardServer {

    public static void main(String[] args)
    {
        SpringApplication.run(CreditCardServer.class,args);
    }

}

