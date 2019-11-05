package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
public class OrderProcessingServiceBean {

	@PersistenceContext
	EntityManager entityManager;
	
//    @WebServiceRef(wsdlLocation = "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
//    private PaymentProcessor paymentService;

    private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";
    /**
     * Default constructor.
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
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
