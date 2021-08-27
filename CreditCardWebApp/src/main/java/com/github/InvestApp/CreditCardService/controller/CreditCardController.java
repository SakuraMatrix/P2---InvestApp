package com.github.InvestApp.CreditCardService.controller;

import com.github.InvestApp.CreditCardService.domain.CreditCard;
import com.github.InvestApp.CreditCardService.service.CreditCardService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ch.qos.logback.classic.Logger;

@RestController
public class CreditCardController {

    private static final Logger log = (Logger) LoggerFactory.getLogger("controller");

    private final CreditCardService service;




    /**
     * Constructor for the Rest Controller
     *
     * @author Rolando Leiva
     * @param service: The CreditCardService for this instance of the server.
    * */
    public CreditCardController(CreditCardService service)
    {
        log.info("Creating new CreditCardController");
        log.info("Inside one Constructor");
        this.service = service;
    }


    /**
     * A methods used to return all the credit cards in the database
     *
     * @author Rolando Leiva
     * @return A Flux of all Credit Card in the database
     * */
    @GetMapping("/creditcards")
    public Flux<CreditCard> getAll()
    {
        log.info("Retrieving all Credit Card");
        return service.getAll();
    }
    /**
     * method used to find a credit card by account id
     *
     * @author Rolando Leiva
     * @return A Mono of one Credit Card
     * */
    @GetMapping("/creditcards/{account_id}")
    public Mono<CreditCard> get(@PathVariable("account_id") Integer account_id)
    {
        log.info("Retrieving a Credit Card");
        return service.get(account_id);
    }



}
