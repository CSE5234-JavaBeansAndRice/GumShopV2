package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}


	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}


    @RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
    public String submitPaymentInfo() throws Exception {
        return "HelloJSP";

    }

    @RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
    public String displayShippingEntry() throws Exception {
        return "HelloJSP";

    }

    @RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
    public String submitShippingInfo() throws Exception {
        return "HelloJSP";

    }

    @RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
    public String displayCompleteOrder() throws Exception {
        return "HelloJSP";

    }

    @RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
    public String confirmOrder() throws Exception {
        return "HelloJSP";

    }

    @RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
    public String displayConfirmation() throws Exception {
        return "HelloJSP";

    }
}
