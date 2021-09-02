package com.GitHub.InvestApp.LoanServices.Services;

import com.GitHub.InvestApp.LoanServices.Domain.Loan;
import com.GitHub.InvestApp.LoanServices.Repository.LoansRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.UUID;

@Service
public class LoanServices {
    private static final Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("service");

    @Autowired
    private final LoansRepository loanRepo;

    public LoanServices(LoansRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    public Flux<Loan>  findAll() {
        log.info("Query @Service");
      return  loanRepo.findAll();
    }

    public Mono<Loan> create(Loan loan) {
        return loanRepo.save(loan);
    }

    public Mono<Loan> getByID(String id) {
      return loanRepo.findById(Integer.parseInt(id));
    }

    public Flux<Loan> getAllByID(String id){
        return loanRepo.findAllById(Collections.singleton(Integer.parseInt(id)));
    }




/*** TODO **/

    public void updateStatus(Integer id, String status) {
    //return loanRepo.insert(
    //        findAll(id)
    //        .hasElement( "False")
    //        .hasElement("review"), status);
}

    public Mono<Loan> updateApproval(int id, boolean b) {
        // return loanRepo.insert( id,  b);
        return null;
    }

    @Query("SELECT * FROM loans WHERE user_id = 'uid' AND loan_id = 'lid'")
    public void cancelApplication(String id, String loan_id) {
       int uid = Integer.parseInt(id);
       int lid = Integer.parseInt(loan_id);

    }

    public Mono<Void> delete(String id) {
        return loanRepo.deleteById(Integer.parseInt(id));
    }

}