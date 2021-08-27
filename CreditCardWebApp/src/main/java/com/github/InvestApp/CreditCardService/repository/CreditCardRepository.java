package com.github.InvestApp.CreditCardService.repository;

import com.github.InvestApp.CreditCardService.domain.CreditCard;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.Nonnull;

@Repository
public interface CreditCardRepository extends ReactiveCassandraRepository<CreditCard, Integer>{
    @Nonnull
    @Query("SELECT * FROM investapp.creditcards WHERE account_id = ?0")
    Mono<CreditCard> findById(Integer id);

    @Nonnull
    @Query("DELETE FROM investapp.creditcards WHERE account_id = ?0")
    Mono<Void> deleteById(Integer id);



}
