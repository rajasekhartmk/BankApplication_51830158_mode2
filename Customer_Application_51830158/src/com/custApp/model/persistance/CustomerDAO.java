package com.custApp.model.persistance;

import java.util.List;

public interface CustomerDAO {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int custId);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(int custId);
}
