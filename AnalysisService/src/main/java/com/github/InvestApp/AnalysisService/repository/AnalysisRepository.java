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
