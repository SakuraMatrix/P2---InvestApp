package com.github.InvestApp.AnalysisService.repository; 
import java.util.List;

import com.github.InvestApp.AnalysisService.domain.Stocks;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono; 

@Repository
public interface AnalysisRepository extends ReactiveCassandraRepository<Stocks, Integer> {
  
  // default Flux<Stocks> getStocks() {
  //   return Flux.from(this.findAll().map(Stocks::getSymbol()));
  // }
  
  
  // default Flux<Stocks> get(int id) {
  //   return Flux.from(this.findById(id));
  // }
  
  @Query("SELECT * FROM investapp.stocks WHERE account_id = ?0 ALLOW FILTERING")
  Flux<Stocks> get(Integer account_id); 

  @Query("SELECT * FROM investapp.stocks WHERE account_id = ?0 and symbol = ?1 ALLOW FILTERING")
  Mono<Stocks> getBySymbol(Integer account_id, String symbol);
  
  @Query("INSERT INTO investapp.stocks (id, account_id, owned, symbol, name, price, changesPercentage, change, dayLow," + 
  "dayHigh, yearHigh, yearLow, marketCap, priceAvg50, priceAvg200, volume, avgVolume, " +
  "exchange, open, previousClose, eps, pe, earningsAnnouncement, sharesOutstanding, timestamp)" + 
  "VALUES (?0, ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18," + 
   "?19, ?20, ?21, ?22, ?23, ?24);")
  Mono<Stocks> addStock(int id, int account_id, int owned, String symbol, String name, double price, double changesPercentage, double change, 
  double dayLow, double dayHigh, double yearHigh, double yearLow, double marketCap, double priceAvg50, 
  double priceAvg200, double volume, double avgVolume, String exchange, double open, double previousClose, 
  double eps, double pe, String earningsAnnouncement, double sharesOutstanding, double timestamp);
  
  @Query("UPDATE investapp.stocks SET account_id = ?0, owned = owned + ?1, symbol = ?2, " +  
  "name = ?3, price = ?4, changesPercentage = ?5, change = ?6, dayLow = ?7, dayHigh = ?8, yearHigh = ?9, " + 
  "yearLow = ?10, marketCap = ?11, priceAvg50 = ?12, priceAvg200 = ?13, volume = ?14, avgVolume = ?15, " + 
  "exchange = ?16, open = ?17, previousClose = ?18, eps = ?19, pe = ?20, earningsAnnouncement = ?21, " +  
  "sharesOutstanding = ?22, timestamp = ?23" +  
  "WHERE account_id = ?0;")
  Mono<Stocks> updateStock(int account_id, int owned, String symbol, String name, double price, double changesPercentage, double change, 
  double dayLow, double dayHigh, double yearHigh, double yearLow, double marketCap, double priceAvg50, 
  double priceAvg200, double volume, double avgVolume, String exchange, double open, double previousClose, 
  double eps, double pe, String earningsAnnouncement, double sharesOutstanding, double timestamp);
  
  
  // default Mono<Stocks> updateFunds(Integer account_id, Double price) {
  //       this.findById(account_id)
  //           .map(
  //               it -> {
  //                 it.setPrice(price);
  //                 return it;
  //               })
  //           .subscribe(this::save)
  //           .dispose();
  //       return this.findById(account_id);
  //     }
}
