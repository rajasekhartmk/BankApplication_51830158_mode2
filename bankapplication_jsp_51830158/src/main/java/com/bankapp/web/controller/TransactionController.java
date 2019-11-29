package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankapp.model.service.TransactionLogService;

@Controller
@RequestMapping("transactionmgt/")
public class TransactionController {

	@Autowired
	private TransactionLogService service;
	
	@GetMapping(path="/")
	public String allTransactions(ModelMap map){
		map.addAttribute("transactions", service.findAll());
		return "allTransactions";
	}
}
