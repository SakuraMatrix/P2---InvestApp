package com.github.InvestApp.ClientLayer;

import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/")
public class ClientLayerController {
  Path login_account_html ;
  Path account_display_html;
  Path credit_card_display_html;
  private static final Logger log =
      (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("controller");


  public ClientLayerController() throws URISyntaxException {
    log.info("Creating new ClientLayerController");
    login_account_html = Paths.get(ClientLayerApplication.class.getResource("/login_account.html").toURI());
    account_display_html = Paths.get(ClientLayerApplication.class.getResource("/account_display.html").toURI());
    credit_card_display_html = Paths.get(ClientLayerApplication.class.getResource("/credit_card_display.html").toURI());
  }


//  @GetMapping("/stocks")
//  public Flux<Stocks> getAll() {
//    log.info("Showing all stocks");
//    return service.getAll();
//  }
//
//  @GetMapping("/stocks/{account_id}/sell/{id}")
//  public Mono<Stocks> sell(@PathVariable("account_id") int account_id, @PathVariable("id") int id)  {
//    log.info("Selling stock");
//    return service.sellStock(id);
//  }
//
//  @GetMapping("/stocks/{account_id}")
//  public Flux<Stocks> get(@PathVariable("account_id") int id) {
//    log.info("Retrieving stocks for one account");
//    return service.get(id);
//  }
//
//  @GetMapping("/stocks/{account_id}/buy/{symbol}/{owned}")
//  public Mono<Stocks> buy(@PathVariable("account_id") int id, @PathVariable("symbol") String symbol, @PathVariable("owned") int owned) throws JsonMappingException, JsonProcessingException, MalformedURLException, IOException {
//    log.info("Buying new stock");
//    return service.addStock(id, owned, symbol);
//  }

}
