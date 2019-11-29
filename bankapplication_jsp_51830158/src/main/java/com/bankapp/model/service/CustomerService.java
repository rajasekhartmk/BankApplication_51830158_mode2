package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;

public interface CustomerService {

	Customer findByName(String name);
    Customer findByEmail(String email);
    Account findByAccountAccountNumber(Long accountNumber);
    public List<Customer> getAllcustomers();
    public void deleteCustomerById(long id);
    public Customer findById(Long id);
}
