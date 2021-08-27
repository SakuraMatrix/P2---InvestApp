package com.github.InvestApp.AccountService.repository;

import com.github.InvestApp.AccountService.domain.Account;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveCassandraRepository<Account, Integer> {

  default Mono<Account> updateFunds(Integer id, Double funds) {
    this.findById(id)
        .map(
            it -> {
              it.setFunds(funds);
              return it;
            })
        .subscribe(this::save)
        .dispose();
    return this.findById(id);
  }

  default Mono<Account> updateCredit(Integer id, Double credit) {
    this.findById(id)
        .map(
            it -> {
              it.setCredit(credit);
              return it;
            })
        .subscribe(this::save)
        .dispose();
    return this.findById(id);
  }

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
