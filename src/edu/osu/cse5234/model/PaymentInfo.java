package edu.osu.cse5234.model;

public class PaymentInfo {
	private int id;
	private String ccNum;
	private String expiration;
	private String cvv;
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
