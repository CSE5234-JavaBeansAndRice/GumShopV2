package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	private int id;
    
    @Column(name="CC_NUM")
	private String ccNum;
    
    @Column(name="EXPIRATION")
	private String expiration;
    
    @Column(name="CVV")
	private String cvv;
    
    @Column(name="CARDHOLDER")
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
		return id;
	}
	
	public String getCcNum() {
		return ccNum;
	}
	
	public String getExpiration() {
		return expiration;
	}
	
	public String getCvv() {
		return cvv;
	}
	
	public String getCardHolder() {
		return cardHolder;
	}
}
