package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessor;
import com.ups.shipping.client.ShippingInitiationClient;

import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class)
public class OrderProcessingServiceBean {

	@PersistenceContext
	EntityManager entityManager;
	
	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;
	
	@Resource(lookup="jms/emailQ")
	private Queue queue;
	
//    @WebServiceRef(wsdlLocation = "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
//    private PaymentProcessor paymentService;

    private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";
    /**
     * Default constructor.
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    private void notifyUser(Order order) {
    	String message = order.getEmailAddress() + ":" +
    		       "Your order was successfully submitted. " + 
    		     	"You will hear from us when items are shipped. " + 
    		      	new Date();

    		System.out.println("Sending message: " + message);
    		jmsContext.createProducer().send(queue, message);
    		System.out.println("Message Sent!");
    }

    public String processOrder(Order order) {
    	InventoryService service = ServiceLocator.getInventoryService();
    	CreditCardPayment creditCardPayment = new CreditCardPayment(); 
    	ShippingInitiationClient shipping = new ShippingInitiationClient(shippingResourceURI);
    	List<Item> itemList = new ArrayList<Item>();
    	for (LineItem line : order.getLineItems()) {
    		Item item = new Item();
    		item.setName(line.getItemName());
    		item.setItemNumber(line.getItemNumber());
    		item.setAvailableQuantity(line.getQuantity());
    		item.setId(line.getId());
    		itemList.add(item);
    	}
    	service.validateQuantity(itemList);
		service.updateInventory(itemList);
		entityManager.persist(order);
		JsonObject requestJson = Json.createObjectBuilder()
				.add("Organization", "GumShopV2")
				.add("OrderRefId", order.getId())
				.add("Zip", order.getShippingInfo().getZip())
				.add("ItemsNumber", order.getLineItems().size())
				.build();
		JsonObject responseJson = shipping.invokeInitiateShipping(requestJson);
		System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted"));
		System.out.println("Shipping Reference Number: " +  responseJson.getInt("ShippingReferenceNumber"));
		entityManager.flush();
		notifyUser(order);
		return "4309320934";
//    	String status = paymentService.processPayment(creditCardPayment);
//    	if (Integer.valueOf(status) < 0) {
//    		return "ERROR";
//    	} else {
//	    	service.validateQuantity(itemList);
//			service.updateInventory(itemList);
//			entityManager.persist(order);
//			entityManager.flush();
//	        return status;
//    	}
    }

    public boolean validateItemAvailability(Order order) {
    	List<Item> itemList = new ArrayList<Item>();
    	for (LineItem line : order.getLineItems()) {
    		Item item = new Item();
    		item.setName(line.getItemName());
    		item.setItemNumber(line.getItemNumber());
    		item.setAvailableQuantity(line.getQuantity());
    		itemList.add(item);
    	}
        return ServiceLocator.getInventoryService().validateQuantity(itemList);
    }

}
