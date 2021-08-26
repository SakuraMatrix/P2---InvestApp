package com.github.InvestApp.AnalysisService.repository; 
import com.github.InvestApp.AnalysisService.domain.Stocks;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono; 

@Repository
public interface AnalysisServiceRepository extends ReactiveCassandraRepository<Stocks, Integer> {
    default Mono<Stocks> updateFunds(Integer account_id, Double price) {
        this.findById(account_id)
            .map(
                it -> {
                  it.setPrice(price);
                  return it;
                })
            .subscribe(this::save)
            .dispose();
        return this.findById(account_id);
      }
}
