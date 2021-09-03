package com.GitHub.InvestApp.LoanServices.Domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.annotation.Nonnull;

@Table("accounts")
public class Accounts {
    @PrimaryKey private Integer id;
    private String first_name;
    private String last_name;

    public Accounts(Integer id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Nonnull
    public static Accounts from(Accounts a) {
        return new Accounts(a.id, a.first_name, a.last_name);
    }

    public Accounts() {}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

}

