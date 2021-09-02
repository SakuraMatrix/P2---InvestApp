package com.github.InvestApp.ClientLayer;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

@SpringBootApplication
@EnableEurekaClient
@PropertySource("classpath:application.properties")
public class ClientLayerApplication {
	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(ClientLayerApplication.class, args);
	}
	@Bean
	public HttpServer httpServer(ApplicationContext context) throws URISyntaxException {
		Path login_account_html = Paths.get(ClientLayerApplication.class.getResource("/login_account.html").toURI());
		Path account_display_html = Paths.get(ClientLayerApplication.class.getResource("/account_display.html").toURI());
		Path credit_card_display_html = Paths.get(ClientLayerApplication.class.getResource("/credit_card_display.html").toURI());
		return HttpServer.create().port(Integer.parseInt(port)).route(routes ->
				routes.get("/login", (request, response) ->
								response.sendFile(login_account_html))
						.post("/account_display", (request, response) ->
								response.send(request.receive().asString()
										.log("http-server")))
						.get("/display_account", (request, response) ->
								response.sendFile(account_display_html))
						.get("/del_transfer", (request, response) ->
								response.sendFile(credit_card_display_html))
		);
	}
}
