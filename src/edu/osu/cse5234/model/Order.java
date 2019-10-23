package edu.osu.cse5234.model;
import java.util.List;


public class Order {
	private int id;
	private String customerName;
	private String emailAddress;
	private List<LineItem> lineItems;
	
	public Order() {
    
    } 
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public List<LineItem> getLineItems(){
		return lineItems;
	}
}
