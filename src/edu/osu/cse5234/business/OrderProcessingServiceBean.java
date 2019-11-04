package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessor;

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
	
    @WebServiceRef(wsdlLocation = "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
    private PaymentProcessor paymentService;

	
    /**
     * Default constructor.
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder(Order order) {
    	InventoryService service = ServiceLocator.getInventoryService();
    	CreditCardPayment creditCardPayment = new CreditCardPayment(); 
    	List<Item> itemList = new ArrayList<Item>();
    	for (LineItem line : order.getLineItems()) {
    		Item item = new Item();
    		item.setName(line.getItemName());
    		item.setItemNumber(line.getItemNumber());
    		item.setAvailableQuantity(line.getQuantity());
    		itemList.add(item);
    	}
    	String status = paymentService.processPayment(creditCardPayment);
    	if (Integer.valueOf(status) < 0) {
    		return "ERROR";
    	} else {
	    	service.validateQuantity(itemList);
			service.updateInventory(itemList);
			entityManager.persist(order);
			entityManager.flush();
	        return status;
    	}
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
