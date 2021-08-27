package com.github.InvestApp.CreditCardService.controller;

import com.github.InvestApp.CreditCardService.domain.CreditCard;
import com.github.InvestApp.CreditCardService.service.CreditCardService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
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
    /**
     * method used to insert a credit card
     *
     * @author Rolando Leiva
     * @return A Mono of one Credit Card
     * @param card: is inserted into the database
     * */
    @PostMapping("/add")
    public Mono<CreditCard> create(@RequestBody CreditCard card)
    {
        log.info("Inserting a Credit Card");
        log.info(card.toString());
        return service.create(card);
    }
    /**
     * method used to delete a credit card
     *
     * @author Rolando Leiva
     * @return A Mono of one Credit Card
     * @param id: used to find and delete a credit card in the database
     * */
    @DeleteMapping("/creditcards/delete/{account_id}")
    public Mono<Void> delete(@PathVariable("account_id") String id) {
        log.info("Deleting an CreditCard");
        log.info("Id is " +id);
        return service.delete(Integer.parseInt(id));
    }


}
