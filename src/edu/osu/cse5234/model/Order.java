package edu.osu.cse5234.model;
import java.util.List;

import osu.edu.cse5234.business.view.Item;

public class Order {
	private List<Item> items;
	public Order() {
    
    } 
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public List<Item> getItems() {
		return items;
	}
}
