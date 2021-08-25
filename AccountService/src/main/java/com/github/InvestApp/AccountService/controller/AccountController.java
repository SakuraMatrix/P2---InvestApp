package com.github.InvestApp.AccountService.controller;

import com.github.InvestApp.AccountService.domain.Account;
import com.github.InvestApp.AccountService.service.AccountService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {

  private final AccountService service;

  public AccountController(AccountService service) {
    this.service = service;
  }

  @GetMapping("/accounts")
  public Flux<Account> getAll() {
    return service.getAll();
  }

  @GetMapping("/accounts/{account_id}")
  public Mono<Account> get(@PathVariable("account_id") Integer id) {
    return service.get(id);
  }

  @PutMapping("/")
  @PostMapping("")
  public Mono<Account> create(@RequestBody Account account) {
    return service.create(account);
  }

  @DeleteMapping("{account_id}")
  public Mono<Void> delete(@PathVariable Integer id) {
    return service.delete(id);
  }
}
