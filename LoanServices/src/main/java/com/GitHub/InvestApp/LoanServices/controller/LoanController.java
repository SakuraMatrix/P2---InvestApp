package com.GitHub.InvestApp.LoanServices.controller;

import com.GitHub.InvestApp.LoanServices.Domain.Loan;
import com.GitHub.InvestApp.LoanServices.Services.LoanServices;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.shaded.guava.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * contains all the mapping for the end points.
 * getall
 * getById
 * Save
 * Delete
 *
 */
@RestController
//@CrossOrigin(
//        methods = {POST, GET, OPTIONS, PUT, DELETE},
//        maxAge = 3600,
//        allowedHeaders = {"x-requested", "origin", "content-type", "accept"},
//        origins = "*"
//)
@RequestMapping(value="/loans")
public class LoanController {
    @Autowired
    private final LoanServices loanService;
    public LoanController(LoanServices loanService){
        this.loanService = loanService;
    }

    public CqlSession session() {
        return CqlSession.builder().build();
    }


    /**
     *  A REST endpoint (PUT) retrieve all applications from DB
     * @author Leonard Nganga
     * @return A flux container to retrieve all accounts
     * @param = "vall/0": this works when we call the repository layer  directly instead of routing via the service layer
     **/
     @GetMapping("/vall/0")
     public Flux<Loan> getAllLoans() {
     return loanService.findAll();
     }


    /**
     * A REST endpoint (GET) to create a new loan application entry
     * @author Leonard Nganga
     * @endpoint: new/{param}
     * @return A Mono representing the updated Account
     */
     @PostMapping("/new/{param}")
     public Mono<Loan> create(@RequestBody Loan loan){
     Preconditions.checkNotNull(loan);
     return loanService.create(loan);
     }

    /**
     *  A REST endpoint (PUT) to retrieve an application by account_id
     * @author Leonard Nganga
     * @return A flux container to retrieve records for a single user Account
     * @param id : Account ID.
     * @endpoint : vone/{lid} Type: int
     **/
    @GetMapping("/vone/{id}")
    public Mono<Loan> findByID(@PathVariable String id){
        return loanService.getByID(id);
    }


    /**
     *  A REST endpoint (PUT) to retrieve All Accounts records for a single user id
     * @author Leonard Nganga
     * @return A flux container to retrieve records for a single user Account
     * @param id : Account User ID.
     * @endpoint: vall/{id} , Type String
     **/
    @GetMapping("/vall/{id}")
    public Flux<Loan> findByUid(@PathVariable String id){
        return loanService.getAllByID(id);
    }


    /**
     * A REST endpoint (PUT) to update the Status of the Loan Application
     * @author Leonard Nganga
     * @param id: User Id of the account to update
     * @param status: The new value of available of the application status
     * @endpoint: append/{param} , Type String
     * @return A Mono representing the updated Account
     **/
    @PutMapping("/append/{param}")
    public void updateStatus( @PathVariable("account_id") Integer id, @RequestBody String status) {
        Preconditions.checkNotNull(status);
        loanService.updateStatus(id, status);
    }


    /**
     * A REST endpoint (POST) to update Approval status of the Loan Application
     * @author Leonard Nganga
     * @param :{param} approval status
     * @param approved: New status of the Approved value
     * @return A Mono representing the updated Account
     */
    @PostMapping("/append_approval/{param}")
    public Mono<Loan> updateApproval(
            @PathVariable("uid") Integer id, @RequestBody Boolean approved) {
        return loanService.updateApproval(id, approved);
    }



    /**
     * A REST endpoint delete an account by ID
     * @author Leonard Nganga
     * @param id : The Id of the account to update
     * @endpoint : rm/{id}
     * @return A Mono representing the updated Account
     */
//    @GetMapping("/rm/{param}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteByID(String id, String loan_id){
//        log.info("Deleting Applications for a  Single account" + id);
//        loanService.cancelApplication(id, loan_id);
//    }

}

