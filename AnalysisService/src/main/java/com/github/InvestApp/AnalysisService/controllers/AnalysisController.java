package com.github.InvestApp.AnalysisService.controllers;

import ch.qos.logback.classic.Logger;

import java.util.Arrays;

import com.github.InvestApp.AnalysisService.domain.Stocks;
import com.github.InvestApp.AnalysisService.service.AnalysisService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class AnalysisController {

  private static final Logger log =
      (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("controller");

  private final AnalysisService service;

  
  public AnalysisController(AnalysisService service) {
    log.info("Creating new AnalysisController");
    this.service = service;
  }


  // @GetMapping("/stocks")
  // public Flux<Stocks> getAll() {
  //   log.info("Showing all stocks");
  //   return service.getAll();
  // } 

  @GetMapping("/stocks/{account_id}")
  public Flux<Stocks> get(@PathVariable("account_id") int id) {
    log.info("Retrieving stocks for one account");  
    return service.get(id);
  }

}