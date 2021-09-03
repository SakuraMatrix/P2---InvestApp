package com.GitHub.InvestApp.LoanServices.Repository;




import com.GitHub.InvestApp.LoanServices.Domain.Accounts;  //for microservice direct this to the Accounts microservice
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends ReactiveCassandraRepository<Accounts, Integer> {
}
