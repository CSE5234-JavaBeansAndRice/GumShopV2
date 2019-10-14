package edu.osu.cse5234.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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

    /**
     * Default constructor.
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder(Order order) {
    	InventoryService service = ServiceLocator.getInventoryService();
    	List<Item> items = order.getItems();
    	if (service.validateQuantity(items)) {
    		service.updateInventory(items);
            return "3409439598423";
    	}
    	return "none";
    }

    public boolean validateItemAvailability(Order order) {
        return ServiceLocator.getInventoryService()
                .validateQuantity(order.getItems());
    }

}
