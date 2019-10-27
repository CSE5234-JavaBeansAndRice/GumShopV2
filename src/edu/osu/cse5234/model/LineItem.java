package edu.osu.cse5234.model;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_ORDER_LINE_ITEM")
public class LineItem {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	private int id;
    
    @Column(name="ITEM_ID")
	private int itemNumber;
    
    @Column(name="ID_NAME") 
	private String itemName;
   	
    @Column(name="QUANTITY") 
	private int quantity;
	
    @Transient
	private double price;
    
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
