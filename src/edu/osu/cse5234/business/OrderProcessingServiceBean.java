package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
public class OrderProcessingServiceBean {
	
	@PersistenceContext
	private EntityManager entityManager;

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
}
