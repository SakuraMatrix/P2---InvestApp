package com.github.InvestApp.CreditCardService.domain;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.annotation.Nonnull;

@Data
@Table("creditcards")
public class CreditCard {
    @PrimaryKeyColumn(name = "account_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private int account_id;
    @PrimaryKeyColumn(name = "card_num", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    private String card_num;
    private String first_name;
    private String last_name;
    private String type;
    private String ccv;
    private String exp_date;


    public CreditCard(int account_id, String card_num, String first_name, String last_name, String type, String ccv, String exp_date) {
        this.account_id = account_id;
        this.card_num = card_num;
        this.first_name = first_name;
        this.last_name = last_name;
        this.type = type;
        this.ccv = ccv;
        this.exp_date = exp_date;
    }
    public CreditCard()
    {

    }


    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    @Nonnull
    public static CreditCard from(CreditCard cc)
    {
        return new CreditCard(cc.account_id,cc.card_num,cc.first_name,cc.last_name,
                cc.type,cc.ccv,cc.exp_date);
    }
}
