package com.custApp.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.custApp.model.persistance.Customer;
import com.custApp.model.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	

	@RequestMapping(value = "allcustomer", method = RequestMethod.GET)
	public String getCustomers(ModelMap map) {
		map.addAttribute("customers", customerService.getAllCustomers());
		return "all_customer";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String addCustomerPost(@Valid Customer customer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "addcustomer";
		}else{
		if (customer.getId() == 0) {
			customerService.addCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}
		return "redirect:allcustomer";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req) {
		int custId = Integer.parseInt(req.getParameter("id"));
		customerService.removeCustomer(custId);
		return "redirect:allcustomer";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateCustomer(HttpServletRequest req, ModelMap map) {
		int custId = Integer.parseInt(req.getParameter("id"));
		Customer customerToBeUpdated = customerService.getCustomerById(custId);
		map.addAttribute("customer", customerToBeUpdated);
		return "addcustomer";
	}
	
	@ModelAttribute(value="typeList")
	public List<String> getTypeList(){
		return Arrays.asList("regular","occasional","new");
	}
	
}
