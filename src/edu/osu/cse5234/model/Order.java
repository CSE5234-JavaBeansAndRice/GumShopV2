package edu.osu.cse5234.model;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	private int id;
    
    @Column(name="CUSTOMER_NAME")
	private String customerName;
    
    @Column(name="CUSTOMER_EMAIL")
	private String emailAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<LineItem> items;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PAYMENT_INFO_ID_FK")
	private PaymentInfo payment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SHIPPING_INFO_ID_FK")
	private ShippingInfo shipping;

	
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
	
	public void setLineItems(List<LineItem> items) {
		this.items = items;
	}
	
	public void setPaymentInfo(PaymentInfo payment) {
		this.payment = payment;
	}
	
	public void setShippingInfo(ShippingInfo shipping) {
		this.shipping = shipping;
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
		return items;
	}
	
	public PaymentInfo getPaymentInfo() {
		return payment;
	}
	
	public ShippingInfo getShippingInfo() {
		return shipping;
	}
}
