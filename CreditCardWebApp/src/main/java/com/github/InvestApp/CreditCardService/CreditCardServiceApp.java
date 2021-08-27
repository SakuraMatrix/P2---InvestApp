package com.github.InvestApp.CreditCardService;


import ch.qos.logback.classic.Logger;
import com.github.InvestApp.CreditCardService.controller.CreditCardController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class CreditCardServiceApp {

    private @Autowired
    CreditCardController controller;

    @Value("${server.port}")
    private String port;

    private static final Logger log = (Logger) LoggerFactory.getLogger("Service App");
    public static void main(String[] args)
    {
        log.info("Running Spring Application");
        SpringApplication.run(CreditCardServiceApp.class);
    }


    @Bean
    public HttpServer httpServer(ApplicationContext context)
    {
        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        return HttpServer.create().port(Integer.parseInt(port)).handle(adapter);
    }
}
