package com.github.InvestApp.AccountService.repository;

import com.github.InvestApp.AccountService.domain.Account;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveCassandraRepository<Account, Integer> {
  @Query("UPDATE investapp.accounts SET funds = ?1 WHERE id = ?0 ")
  Mono<Account> updateFunds(Integer id, Double funds);

  @Query("UPDATE investapp.accounts SET credit = ?1 WHERE id = ?0 ")
  Mono<Account> updateCredit(Integer id, Double credit);

  default Mono<Double> getCredit(Integer id) {
    return Mono.from(this.findById(id).map(Account::getCredit));
  }

  default Mono<Double> getFunds(Integer id) {
    return Mono.from(this.findById(id).map(Account::getFunds));
  }

  default Flux<Double> getAllCredit() {
    return Flux.from(this.findAll().map(Account::getCredit));
  }

  default Flux<Double> getAllFunds() {
    return Flux.from(this.findAll().map(Account::getFunds));
  }
}
