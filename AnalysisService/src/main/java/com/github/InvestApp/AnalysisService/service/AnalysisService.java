package com.github.InvestApp.AnalysisService.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

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

  // public Flux<Stocks> update(int id) { 
  //   ArrayList<Stocks> stockList;
  //   Flux<Stocks> allStocks = getAll();  
  //   Iterable<Stocks> it = allStocks.toIterable();  
  //   it.forEach(action);

  //   return repo.get(id);
  // } 
  public Mono<Stocks> exists(int account_id, String symbol){ 
    return repo.getBySymbol(account_id, symbol);
  }

  public Mono<Stocks> addStock(int account_id, int owned, String symbol) throws JsonMappingException, JsonProcessingException, MalformedURLException, IOException{   
    // if(exists(1, "JPM") == null) 
    //   System.out.println("Big Baby Nuzz");  
    // else 
    //   System.out.println("No nuzz"); 
    Mono<Stocks> holder = exists(1, "JPM"); 
    holder.block().getSymbol(); 
    if(holder == null) 
      System.out.println("Null");  
    else 
      System.out.println("No null");
    ObjectMapper objectMapper = new ObjectMapper();
    HttpHandler handler = new HttpHandler(symbol);   
    Stocks stock = objectMapper.readValue(handler.sendHttp(symbol), Stocks.class);   
    //System.out.println("The price of stock " + symbol + " is: $" + stock.getPrice());
    stock.setId(++keyId);  
    stock.setAccount_Id(account_id); 
    stock.setOwned(owned);   

    //  return this.repo.updateStock( stock.getAccount_Id(), stock.getOwned(), stock.getSymbol(), stock.getName(), 
    // stock.getPrice(), stock.getChangesPercentage(), stock.getChange(), stock.getDayLow(), stock.getDayHigh(),  
    // stock.getYearHigh(), stock.getYearLow(), stock.getMarketCap(), stock.getPriceAvg50(), stock.getPriceAvg200(), 
    // stock.getVolume(), stock.getAvgVolume(), stock.getExchange(), stock.getOpen(), stock.getPreviousClose(),  
    // stock.getEps(), stock.getPe(), stock.getEarningsAnnouncement(), stock.getSharesOutstanding(), stock.getTimestamp());

    return this.repo.addStock(stock.getId(), stock.getAccount_Id(), stock.getOwned(), stock.getSymbol(), stock.getName(), 
    stock.getPrice(), stock.getChangesPercentage(), stock.getChange(), stock.getDayLow(), stock.getDayHigh(),  
    stock.getYearHigh(), stock.getYearLow(), stock.getMarketCap(), stock.getPriceAvg50(), stock.getPriceAvg200(), 
    stock.getVolume(), stock.getAvgVolume(), stock.getExchange(), stock.getOpen(), stock.getPreviousClose(),  
    stock.getEps(), stock.getPe(), stock.getEarningsAnnouncement(), stock.getSharesOutstanding(), stock.getTimestamp());
    
} 
  
}