package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewOrderEntryForm(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Order order = new Order();
        String[] gums = { "Bubble", "Spearmint", "Peppermint", "Wintergreen",
                "Cinnamon" };
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i < 5; i++) {
            Item item = new Item();
            item.setName(gums[i]);
            item.setPrice(i + .5);
            item.setQuantity((i / 3) + 1);
            items.add(item);
        }
        order.setItems(items);
        request.getSession().setAttribute("order", order);
        // ... instantiate and set order object with items to display
        return "OrderEntryForm";
    }

    @RequestMapping(path = "/submitItems", method = RequestMethod.POST)
    public String submitItems(@ModelAttribute("order") Order order,
            HttpServletRequest request) {
        request.getSession().setAttribute("order", order);
        return "redirect:/purchase/paymentEntry";
    }

    @RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
    public String viewPaymentEntryPage(HttpServletRequest request,
            HttpServletResponse response) {
        request.setAttribute("payment", new PaymentInfo());
        return "PaymentEntryForm";
    }

    @RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
    public String submitPaymentInfo(@ModelAttribute("payment") PaymentInfo payment,
    		HttpServletRequest request) throws Exception {
    	request.getSession().setAttribute("payment", payment);
        return "redirect:/purchase/shippingEntry";

    }

    @RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
    public String displayShippingEntry(HttpServletRequest request,
    		HttpServletResponse response) throws Exception {
        request.setAttribute("shipping", new ShippingInfo());
        return "ShippingEntryForm";

    }

    @RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
    public String submitShippingInfo(@ModelAttribute("shipping") ShippingInfo shipping,
    		HttpServletRequest request) throws Exception {
    	request.getSession().setAttribute("shipping", shipping);
        return "redirect:/purchase/viewOrder";

    }

    @RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
    public String displayCompleteOrder(@ModelAttribute("order") Order order,
    		HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("order", order);
        return "ViewOrder";

    }

    @RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
    public String confirmOrder(@ModelAttribute("order") Order order,
    		HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("order", order);
        return "redirect:/purchase/viewConfirmation";

    }

    @RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
    public String displayConfirmation() throws Exception {
        return "Confirmation";

    }
}
