package com.GitHub.InvestApp.LoanServices.Repository;

import com.GitHub.InvestApp.LoanServices.Domain.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface LoansRepository extends ReactiveCassandraRepository<Loan, Integer> {
    static final Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("repo");

    public default void logger(){
    log.info("Repo check....");
    }

    @Query("UPDATE investapp.loans SET account_id = ?0 AND loan_id = ?1, status=cancelled")
    void getLoanByAccount_idAndLoan_id(Integer account_id, String loan_id);

    @Query("DELETE investapp.loans SET account_id = ?0 AND loan_id = ?1")
    void deleteLoanByAccount_idAfterAndLoan_id(Integer account_id, String loan_id);

}
