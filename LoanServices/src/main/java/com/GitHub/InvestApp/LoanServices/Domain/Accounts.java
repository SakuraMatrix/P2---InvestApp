package com.GitHub.InvestApp.LoanServices.Domain;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;



//@Table("accounts')
public class Accounts{
    @Id
    @PrimaryKey private int id;
    String first_name;
    String last_name;
    double funds;
    double credit;

    public Accounts(){}




}
