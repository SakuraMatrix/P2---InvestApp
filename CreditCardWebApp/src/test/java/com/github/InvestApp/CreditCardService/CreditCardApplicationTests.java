package com.github.InvestApp.CreditCardService;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootTest
@EnableWebFlux
public class CreditCardApplicationTests {

    @Autowired
    ApplicationContext context;

    WebTestClient rest = WebTestClient.bindToApplicationContext(context).build();

    @Test
    void contextLoads()
    {

    }


}
