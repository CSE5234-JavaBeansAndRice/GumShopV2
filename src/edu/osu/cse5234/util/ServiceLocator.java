package edu.osu.cse5234.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.InventoryService;

public class ServiceLocator {

    public static OrderProcessingServiceBean getOrderProcessingService() {
        try {
            return (OrderProcessingServiceBean) InitialContext.doLookup(
                    "java:module/OrderProcessingServiceBean!edu.osu.cse5234.business.OrderProcessingServiceBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

    public static InventoryService getInventoryService() {
        try {
            return (InventoryService) InitialContext.doLookup(
                    "java:global/Gum-Shop-V2-EJBEAR/Gum-Shop-V2-EJB/InventoryServiceBean!edu.osu.cse5234.business.view.InventoryService");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

}
