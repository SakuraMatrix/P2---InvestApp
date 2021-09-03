package com.GitHub.InvestApp.LoanServices.Repository;

import com.GitHub.InvestApp.LoanServices.Domain.Loan;
import com.GitHub.InvestApp.LoanServices.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface LoansRepository extends ReactiveCassandraRepository<Loan, Integer> {

    @Query("UPDATE investapp.loans SET account_id = ?0 AND loan_id = ?1, status=cancelled")
    Mono<Loan> getLoanByAccount_idAndLoan_id(Integer account_id, String loan_id);

    @Query("UPDATE investapp.loans SET status = ?1 WHERE id = ?0 ")
    Mono<Loan> updateLoan(Integer id, boolean b);
}
