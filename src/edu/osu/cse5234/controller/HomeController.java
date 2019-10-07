package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Home";
	}
	
//	@RequestMapping(path = "/new", method = RequestMethod.GET)
//	public String printHelloNew() throws Exception {
//		return "HelloJSP";
//		
//	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String displayAboutUs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "AboutUs";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String displayContactUs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ContactUs";
	}
}
