package com.github.InvestApp.AccountService.service;

import com.github.InvestApp.AccountService.domain.Account;
import com.github.InvestApp.AccountService.repository.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

  private final AccountRepository repo;

  public AccountService(AccountRepository repo) {
    this.repo = repo;
  }

  public Flux<Account> getAll() {
    return repo.findAll();
  }

  public Mono<Account> get(Integer id) {
    return repo.findById(id);
  }

  public Mono<Account> create(Account account) {
    return repo.save(account);
  }

  public Mono<Void> delete(Integer id) {
    return repo.deleteById(id);
  }

  public Mono<Account> updateFunds(Integer id, double funds) {
    return repo.updateFunds(id, funds);
  }

  public Mono<Account> updateCredit(Integer id, double credit) {
    return repo.updateCredit(id, credit);
  }
}
