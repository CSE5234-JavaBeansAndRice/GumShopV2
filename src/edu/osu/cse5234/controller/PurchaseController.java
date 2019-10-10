package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewOrderEntryForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	Order order = new Order();
        request.setAttribute("order", order);
        InventoryService inventoryService = ServiceLocator.getInventoryService();
        Inventory inventory = inventoryService.getAvailableInventory();
        order.setItems(inventory.getItemList());
        request.getSession().setAttribute("order", order);
        // ... instantiate and set order object with items to display
        return "OrderEntryForm";
    }

    @RequestMapping(value = "/submitItems", method = RequestMethod.POST)
    public String submitItems(@ModelAttribute("order") Order order,
            HttpServletRequest request) {
    	OrderProcessingServiceBean orderProcessingServiceBean = ServiceLocator.getOrderProcessingService();
    	request.getSession().setAttribute("order", order);
        if (orderProcessingServiceBean.validateItemAvailability(order)) {
        	return "redirect:/purchase/paymentEntry";
        }
        else {
        	request.setAttribute("message", "Please resubmit item quantities.");
        	return "OrderEntryForm";
        }
    }

    @RequestMapping(value = "/paymentEntry", method = RequestMethod.GET)
    public String viewPaymentEntryPage(HttpServletRequest request,
            HttpServletResponse response) {
        PaymentInfo payment = new PaymentInfo();
        request.getSession().setAttribute("payment", payment);
        return "PaymentEntryForm";
    }

    @RequestMapping(value = "/submitPayment", method = RequestMethod.POST)
    public String submitPaymentInfo(@ModelAttribute("payment") PaymentInfo payment,
    		HttpServletRequest request, @RequestParam String ccNum, @RequestParam String expiration, @RequestParam String cvv,
            @RequestParam String cardHolder) throws Exception {
        payment.setCcNum(ccNum);
        payment.setExpiration(expiration);
        payment.setCvv(cvv);
        payment.setCardHolder(cardHolder);
    	request.getSession().setAttribute("payment", payment);
        return "redirect:/purchase/shippingEntry";

    }

    @RequestMapping(value = "/shippingEntry", method = RequestMethod.GET)
    public String displayShippingEntry(HttpServletRequest request,
    		HttpServletResponse response) throws Exception {
        request.setAttribute("shipping", new ShippingInfo());
        return "ShippingEntryForm";

    }

    @RequestMapping(value = "/submitShipping", method = RequestMethod.POST)
    public String submitShippingInfo(@ModelAttribute("shipping") ShippingInfo shipping,
    		HttpServletRequest request, @RequestParam String name, @RequestParam String addressLine1, @RequestParam String addressLine2,
            @RequestParam String city, @RequestParam String state, @RequestParam String zip) throws Exception {
        shipping.setName(name);
        shipping.setAddressLine1(addressLine1);
        shipping.setAddressLine2(addressLine2);
        shipping.setCity(city);
        shipping.setState(state);
        shipping.setZip(zip);
    	request.getSession().setAttribute("shipping", shipping);
        return "redirect:/purchase/viewOrder";

    }

    @RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
    public String displayCompleteOrder(HttpServletResponse response, 
    		HttpServletRequest request) throws Exception {
    	//Order order = (Order) request.getSession().getAttribute("order");
    	Order order = (Order) request.getSession().getAttribute("order");
        return "ViewOrder";

    }

    @RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
    public String confirmOrder(@ModelAttribute("order") Order order,
    		HttpServletRequest request) throws Exception {
    	OrderProcessingServiceBean orderProcessingServiceBean = ServiceLocator.getOrderProcessingService();
    	String confirmationCode = orderProcessingServiceBean.processOrder(order);
        request.getSession().setAttribute("order", order);
        request.getSession().setAttribute("confirmationCode", confirmationCode);
        return "redirect:/purchase/viewConfirmation";

    }

    @RequestMapping(value = "/viewConfirmation", method = RequestMethod.GET)
    public String displayConfirmation() throws Exception {
        return "Confirmation";

    }
}
