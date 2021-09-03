package com.GitHub.InvestApp.LoanServices.Services;

import com.GitHub.InvestApp.LoanServices.Domain.Accounts;
import com.GitHub.InvestApp.LoanServices.Domain.Loan;
import com.GitHub.InvestApp.LoanServices.Repository.AccountsRepository;
import com.GitHub.InvestApp.LoanServices.Repository.LoansRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class LoanServices {
    private static final Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("service");

    @Autowired
    private final LoansRepository loanRepo;
    private final AccountsRepository accountsRepository;


    public LoanServices(LoansRepository loanRepo, AccountsRepository accountsRepository) {
        this.loanRepo = loanRepo;
        this.accountsRepository = accountsRepository;
    }

    public Flux<Loan> findAll() {
        log.info("Query @Service");
        return loanRepo.findAll();
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

    public void cancelApplication(String id, String loan_id) {
        int uid = Integer.parseInt(id);
        loanRepo.getLoanByAccount_idAndLoan_id(uid,loan_id);
    }

    public void delete(String id, String loan_id) {
       int uid = Integer.parseInt(id);
        loanRepo.deleteLoanByAccount_idAfterAndLoan_id(uid, loan_id);
    }

/*** TODO **/

    public void updateStatus(Integer id, String status) {

}

    public Mono<Loan> updateApproval(int id, boolean b) {
        // return loanRepo.insert( id,  b);
        return null;
    }


    public Mono<Accounts> getAccount(String id) {
        int uid = Integer.parseInt(id);
        return accountsRepository.findById(uid);

    }

    public Flux<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }
}