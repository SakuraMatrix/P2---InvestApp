package com.github.InvestApp.CreditCardService.service;

import com.github.InvestApp.CreditCardService.domain.CreditCard;
import com.github.InvestApp.CreditCardService.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardService {

    @Autowired
    private  CreditCardRepository repo;


    public CreditCardService(CreditCardRepository repo) {
        this.repo = repo;
    }

    public CreditCardService() {

    }
    public Flux<CreditCard> getAll()
    {
        return repo.findAll();
    }

    public Mono<CreditCard> get(Integer account_id)
    {
        return repo.findById(account_id);
    }

    public Mono<CreditCard> create(CreditCard creditCard)
    {
        return repo.save(creditCard);
    }

    public Mono<Void> delete(Integer id)
    {
        return repo.deleteById(id);
    }
}
