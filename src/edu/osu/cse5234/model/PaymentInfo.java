package edu.osu.cse5234.model;

public class PaymentInfo {
	private String ccNum;
	private String expiration;
	private String cvv;
	private String cardHolder;
	
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
