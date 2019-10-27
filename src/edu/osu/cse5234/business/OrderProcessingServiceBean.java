package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
    /**
     * Default constructor.
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder(Order order) {
    	InventoryService service = ServiceLocator.getInventoryService();
    	List<Item> itemList = new ArrayList<Item>();
    	for (LineItem line : order.getLineItems()) {
    		Item item = new Item();
    		item.setName(line.getItemName());
    		item.setItemNumber(line.getItemNumber());
    		itemList.add(item);
    	}
    	service.validateQuantity(itemList);
		service.updateInventory(itemList);
		entityManager.persist(order);
		entityManager.flush();
        return "3409439598423";
    	    }

    public boolean validateItemAvailability(Order order) {
    	List<Item> itemList = new ArrayList<Item>();
    	for (LineItem line : order.getLineItems()) {
    		Item item = new Item();
    		item.setName(line.getItemName());
    		item.setItemNumber(line.getItemNumber());
    		itemList.add(item);
    	}
        return ServiceLocator.getInventoryService().validateQuantity(itemList);
    }

}
