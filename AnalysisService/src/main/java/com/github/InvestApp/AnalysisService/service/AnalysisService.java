package com.github.InvestApp.AnalysisService.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.InvestApp.AnalysisService.domain.Stocks;
import com.github.InvestApp.AnalysisService.repository.AnalysisRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnalysisService {

  private final AnalysisRepository repo; 
  static int keyId = 2;

  public AnalysisService(AnalysisRepository repo) {
    this.repo = repo;
  }

  public Flux<Stocks> getAll() {
    return repo.findAll();
  }
  

  public Flux<Stocks> get(int id) {
    return repo.get(id);
  } 

  public Mono<Stocks> addStock(int account_id, int owned, String symbol) throws JsonMappingException, JsonProcessingException, MalformedURLException, IOException{   
    ObjectMapper objectMapper = new ObjectMapper();
    HttpHandler handler = new HttpHandler(symbol);   
    Stocks stock = objectMapper.readValue(handler.sendHttp(symbol), Stocks.class);   
    //System.out.println("The price of stock " + symbol + " is: $" + stock.getPrice());
    stock.setId(++keyId);  
    stock.setAccount_Id(account_id); 
    stock.setOwned(owned); 
    return this.repo.addStock(stock.getId(), stock.getAccount_Id(), stock.getOwned(), stock.getSymbol(), stock.getName(), 
    stock.getPrice(), stock.getChangesPercentage(), stock.getChange(), stock.getDayLow(), stock.getDayHigh(),  
    stock.getYearHigh(), stock.getYearLow(), stock.getMarketCap(), stock.getPriceAvg50(), stock.getPriceAvg200(), 
    stock.getVolume(), stock.getAvgVolume(), stock.getExchange(), stock.getOpen(), stock.getPreviousClose(),  
    stock.getEps(), stock.getPe(), stock.getEarningsAnnouncement(), stock.getSharesOutstanding(), stock.getTimestamp());
    
} 
  
}