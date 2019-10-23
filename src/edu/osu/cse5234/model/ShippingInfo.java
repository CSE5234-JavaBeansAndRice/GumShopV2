package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHIPPING_INFO")
public class ShippingInfo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	private int id;
    
    @Column(name="NAME")
	private String name;
    
    @Column(name="ADDRESS_LINE_1")
	private String addressLine1;
    
    @Column(name="ADDRESS_LINE_2")
	private String addressLine2;
    
    @Column(name="CITY")
	private String city;
    
    @Column(name="STATE")
	private String state;
    
    @Column(name="ZIP")
	private String zip;

	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
}
