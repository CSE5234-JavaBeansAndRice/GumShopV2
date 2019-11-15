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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class)
public class OrderProcessingServiceBean {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup="jms/emailQ")
	private Queue queue;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	List<Item> itemList = new ArrayList<Item>();
    	for (LineItem lineItem : order.getLineItems()) {
    		Item item = new Item();
    		item.setItemNumber(lineItem.getItemNumber());
    		item.setQuantity(lineItem.getQuantity());
    		itemList.add(item);
    	}
    	inventoryService.validateQuantity(itemList);
    	inventoryService.updateInventory(itemList);
    	entityManager.persist(order);
    	entityManager.flush();
    	notifyUser(order.getEmailAddress());
    	return "123";
    }
    
    public boolean validateItemAvailability(Order order) {
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	List<Item> itemList = new ArrayList<Item>();
    	for (LineItem lineItem : order.getLineItems()) {
    		Item item = new Item();
    		item.setItemNumber(lineItem.getItemNumber());
    		item.setQuantity(lineItem.getQuantity());
    		itemList.add(item);
    	}
    	return inventoryService.validateQuantity(itemList);
    }
    
    private void notifyUser(String customerEmail) {
    	String message = customerEmail + ":" + "Your order was successfully submitted. " + "You will hear from us when items are shipped. " + new Date();
    	System.out.println("Sending message: " + message);
    	jmsContext.createProducer().send(queue, message);
    	System.out.println("Message Sent!");
    }

}
