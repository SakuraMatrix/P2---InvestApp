package com.github.InvestApp.AccountService.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.annotation.Nonnull;

@Table("accounts")
public class Account {
  @PrimaryKey private Integer id;
  private String firstName;
  private String lastName;
  private double funds;
  private double credit;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public Account(Integer id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Account(Integer id, String firstName, String lastName, double funds, double credit) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.funds = funds;
    this.credit = credit;
  }

  @Nonnull
  public static Account from(Account a) {
    return new Account(a.id, a.firstName, a.lastName, a.funds, a.credit);
  }
}