package com.GitHub.InvestApp.LoanServices.Domain;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Table("loans")
public class Loan {
    @Id
    @PrimaryKey private int account_id;
    UUID loan_id;
    Timestamp timestamp;
    double loan_amount;
    String purpose;
    double gross_earning;
    double total_expenses;
    int loan_term;
    String loan_status;
    boolean approved;

    public Loan(){}


    @NonNull
    public static Loan from(Loan l){
        return new Loan(l.loan_id, l.account_id, l.timestamp, l.loan_amount, l.purpose, l.gross_earning, l.total_expenses, l.loan_term, l.loan_status, l.approved);
    }

    @PersistenceConstructor
    public Loan(UUID loan_id, int account_id, Timestamp timestamp, double loan_amount, String purpose, double gross_earning, double total_expenses, int loan_term, String loan_status, boolean approved) {
        this.loan_id = loan_id;
        this.account_id = account_id;
        this.timestamp  = timestamp;
        this.loan_amount = loan_amount;
        this.purpose = purpose;
        this.gross_earning = gross_earning;
        this.total_expenses = total_expenses;
        this.loan_term  = loan_term;
        this.loan_status = loan_status;
        this.approved = approved;
    }


    /**
     * Getters and Setters Section
     *
     */
    public UUID getLoan_id(){
        return loan_id;
    }

    public void setLoan_id() {
        this.loan_id = UUID.randomUUID();
    }

    public void setTimestamp(){
       this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Date getTimestamp(){
        return timestamp;
    }

    public int getAccountId() {
        return account_id;
    }

    public void setAccountId(int id) {
        this.account_id= id;
    }

    public boolean getApproved(){
        return approved;
    }

    public void setApproved(int val){
        this.approved = (val !=0);
    }

    public double getGross_earning(){
       return gross_earning;
    }

    public void setGross_earning(double gross_earning){
        this.gross_earning=gross_earning;
    }

    public double getLoan_amount(){
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount){
        this.loan_amount=loan_amount;
    }

    public double getTotal_expenses(){
        return total_expenses;
    }

    public void setTotal_expenses(double total_expenses){
        this.total_expenses=total_expenses;
    }

    public int getLoan_term(){
        return loan_term;
    }

    public void setLoan_term(int loan_term){
        this.loan_term=loan_term;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose){
        this.purpose =purpose;
    }

    public String getLoan_status(){
        return loan_status;
    }

    public void setLoan_status(String loan_status){
        this.loan_status = loan_status;
    }


    @Override
    public String toString() {
       return  "Loan : "+ loan_id
        + "Timestamp: " +  timestamp
        + " Loan Amount: " + loan_amount
        + " Loan Purpose: " + purpose
        + " Annual Gross Earnings: " + gross_earning
        + " Monthly Total Expenses : " + total_expenses
        + " Loan Term (months): " + loan_term
        + " Application Status: " + loan_status
        + " Approval Status: " + approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Loan loan = (Loan) o;
        return Objects.equals(this.loan_id, loan.loan_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, purpose, loan_amount, loan_status);
    }


}