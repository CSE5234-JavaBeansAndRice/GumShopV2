package edu.osu.cse5234.model;

public class LineItem {
	private int id;
	private int itemNumber;
	private String itemName;
	private double price;
	private int quantity;
	
	public LineItem() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	
	public int getItemNumber() {
		return itemNumber;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
