package com.github.InvestApp.AnalysisService.controllers;

import ch.qos.logback.classic.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.InvestApp.AnalysisService.domain.Stocks;
import com.github.InvestApp.AnalysisService.service.AnalysisService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/analysis")
public class AnalysisController {

  private static final Logger log =
      (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("controller");

  private final AnalysisService service;

  
  public AnalysisController(AnalysisService service) {
    log.info("Creating new AnalysisController");
    this.service = service;
  }


   @GetMapping("/stocks")
   public Flux<Stocks> getAll() {
     log.info("Showing all stocks");
    return service.getAll();
   }  

   @GetMapping("/stocks/{account_id}/sell/{id}")
  public Mono<Stocks> sell(@PathVariable("account_id") int account_id, @PathVariable("id") int id)  {
    log.info("Selling stock");   
    return service.sellStock(id); 
  }

  @GetMapping("/stocks/{account_id}")
  public Flux<Stocks> get(@PathVariable("account_id") int id) {
    log.info("Retrieving stocks for one account");  
    return service.get(id);
  } 

  @GetMapping("/stocks/{account_id}/buy/{symbol}/{owned}")
  public Mono<Stocks> buy(@PathVariable("account_id") int id, @PathVariable("symbol") String symbol, @PathVariable("owned") int owned) throws JsonMappingException, JsonProcessingException, MalformedURLException, IOException {
    log.info("Buying new stock");   
    return service.addStock(id, owned, symbol);
  }

}