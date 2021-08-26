package com.github.InvestApp.AccountService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootTest
@EnableWebFlux
class AccountServiceApplicationTests {

  @Autowired ApplicationContext context;

  WebTestClient rest = WebTestClient.bindToApplicationContext(context).build();

  @Test
  void contextLoads() {}
}
