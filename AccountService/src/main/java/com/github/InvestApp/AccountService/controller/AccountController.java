package com.github.InvestApp.AccountService.controller;

import ch.qos.logback.classic.Logger;
import com.github.InvestApp.AccountService.domain.Account;
import com.github.InvestApp.AccountService.service.AccountService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {

  private static final Logger log =
      (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("controller");

  private final AccountService service;

  /**
   * Constructor for the Rest Controller
   *
   * @author Andrew Gregersen
   * @param service: The AccountService for this instance of the server
   */
  public AccountController(AccountService service) {
    log.info("Creating new AccountController");
    this.service = service;
  }

  /**
   * A REST endpoint (GET) to retrieve all accounts that are in the Cassandra Database
   *
   * @author Andrew Gregersen
   * @return A Flux of all Accounts in the database
   */
  @GetMapping("/accounts")
  public Flux<Account> getAll() {
    log.info("Retrieving all Accounts");
    return service.getAll();
  }

  /**
   * A REST endpoint (GET) to retrieve a single account from the Cassandra Database.
   *
   * @param id: The requested account identification number
   * @return A Mono that contains the requested Account
   */
  @GetMapping("/accounts/{account_id}")
  public Mono<Account> get(@PathVariable("account_id") Integer id) {
    log.info("Retrieving an Account");
    return service.get(id);
  }

  /**
   * A REST endpoint (PUT) to update the funds available for a given account to a new value. @
   *
   * @author Andrew Gregersen
   * @param id: The Id of the account to update
   * @param funds: The new value of available funds
   * @return A Mono representing the updated Account
   */
  @PutMapping("/funds/{account_id}")
  public Mono<Account> updateFunds(
      @PathVariable("account_id") Integer id, @RequestBody double funds) {
    log.info("Updating Funds in an Account");
    return service.updateFunds(id, funds);
  }

  /**
   * A REST endpoint (PUT) to update the Credit available for a given account to a new value. @
   *
   * @author Andrew Gregersen
   * @param id: The Id of the account to update
   * @param credit: The new value of available Credit
   * @return A Mono representing the updated Account
   */
  @PutMapping("/credit/{account_id}")
  public Mono<Account> updateCredit(
      @PathVariable("account_id") Integer id, @RequestBody double credit) {
    log.info("Updating Funds in an Account");
    return service.updateFunds(id, credit);
  }

  /**
   * A REST endpoint (POST) for the creation of a new Account.
   *
   * @author Andrew Gregersen
   * @param account: The Account that is to be added to the Cassandra Database
   * @return A Mono containing the newly added Account. Acts as confirmation of success
   */
  @PostMapping("")
  public Mono<Account> create(@RequestBody Account account) {
    log.info("Creating an Account");
    return service.create(account);
  }

  /**
   * A REST endpoint (DELETE) that deletes a given Account from the Cassandra Database.
   *
   * @author Andrew Gregersen
   * @param id: The Id of the Account to be tombstoned
   * @return A Void Mono
   */
  @DeleteMapping("/accounts/delete/{account_id}")
  public Mono<Void> delete(@PathVariable Integer id) {
    log.info("Deleting an Account");
    return service.delete(id);
  }
}
