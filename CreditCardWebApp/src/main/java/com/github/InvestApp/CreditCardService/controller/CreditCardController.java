package com.github.InvestApp.CreditCardService.controller;

import ch.qos.logback.classic.Logger;
import com.github.InvestApp.CreditCardService.domain.CreditCard;
import com.github.InvestApp.CreditCardService.service.CreditCardService;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/cards")
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
    @GetMapping("")
    public Flux<CreditCard> getAll()
    {
        log.info("Retrieving all Credit Card");
        return service.getAll();
    }
    /**
     * method used to find a credit card by card id
     *
     * @author Rolando Leiva
     * @return A Mono of one Credit Card
     * @param card_id: id used to find the Credit Card
     * */
    @GetMapping("/{card_id}")
    public Mono<CreditCard> get(@PathVariable("card_id") Integer card_id)
    {
        log.info("Retrieving a Credit Card");
        return service.get(card_id);
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
    @DeleteMapping("/delete/{card_id}")
    public Mono<Void> delete(@PathVariable("card_id") String id) {
        log.info("Deleting an CreditCard using Delete");
        log.info("Id is " +id);
        return service.delete(Integer.parseInt(id));
    }
    /**
     * method used to delete a credit card using get
     *
     * @author Rolando Leiva
     * @return A Mono of one Credit Card
     * @param id: used to find and delete a credit card in the database
     * */
    @GetMapping("/delete/{card_id}")
    public Mono<Void> deleteGet(@PathVariable("card_id") String id) {
        log.info("Deleting an CreditCard using Get");
        log.info("Id is " +id);
        return service.delete(Integer.parseInt(id));
    }


}
