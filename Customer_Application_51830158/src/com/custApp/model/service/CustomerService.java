package com.custApp.model.service;

import java.util.List;

import com.custApp.model.persistance.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int custId);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(int custId);
}
