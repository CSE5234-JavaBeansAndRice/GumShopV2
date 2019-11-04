package com.chase.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "CREDIT_CARD_PAYMENT")
public class CreditCardPayment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7389351055825676121L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "CC_NUM")
    private String ccNum;

    @Column(name = "EXPIRATION")
    private String expiration;

    @Column(name = "CVV")
    private String cvv;

    @Column(name = "CARDHOLDER")
    private String cardHolder;

    public void setId(int id) {
        this.id = id;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setCardHolder(String holder) {
        this.cardHolder = holder;
    }

    public int getId() {
        return this.id;
    }

    public String getCcNum() {
        return this.ccNum;
    }

    public String getExpiration() {
        return this.expiration;
    }

    public String getCvv() {
        return this.cvv;
    }

    public String getCardHolder() {
        return this.cardHolder;
    }
}
