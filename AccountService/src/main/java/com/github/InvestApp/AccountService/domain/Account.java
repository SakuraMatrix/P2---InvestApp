package com.github.InvestApp.AccountService.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.annotation.Nonnull;

@Table("accounts")
public class Account {
  @PrimaryKey private Integer id;
  private String first_name;
  private String last_name;
  private double funds;
  private double credit;

  @Nonnull
  public static Account from(Account a) {
    return new Account(a.id, a.first_name, a.last_name, a.funds, a.credit);
  }

  public Account() {}

  public Account(Integer id, String first_name, String last_name) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
  }

  public Account(Integer id, String first_name, String last_name, double funds, double credit) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.funds = funds;
    this.credit = credit;
  }

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

  public double getFunds() {
    return funds;
  }

  public double getCredit() {
    return credit;
  }

  public void setCredit(double credit) {
    this.credit = credit;
  }

  public void setFunds(double funds) {
    this.funds = funds;
  }
}
