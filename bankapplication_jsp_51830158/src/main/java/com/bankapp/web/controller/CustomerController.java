package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankapp.model.service.CustomerService;

@Controller
@RequestMapping(path="customermgt/")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping(path="/")
	public String allCustomers(ModelMap map){
		map.addAttribute("customers", service.getAllcustomers());
		return "allCustomers";
	}
}
