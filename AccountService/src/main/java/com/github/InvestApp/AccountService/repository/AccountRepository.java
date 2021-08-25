package com.github.InvestApp.AccountService.repository;

import com.github.InvestApp.AccountService.domain.Account;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCassandraRepository<Account, Integer> {}
