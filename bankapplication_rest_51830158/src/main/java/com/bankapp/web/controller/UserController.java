package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.User;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountTransactionService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.controller.bean.AccountRequest;
import com.bankapp.web.controller.bean.MessageRequest;


@RestController
@RequestMapping(path="/api")
public class UserController {

	
	@Autowired
	private UserService service;
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private AccountTransactionService accTranService;
	
	@Autowired
	private TransactionLogService logService;
	
	@Autowired
	private AccountService accService;
	
	@GetMapping(path="/user", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAllUsers(){
		return new ResponseEntity<List<User>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/user/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> finduserbyId(@PathVariable(name="id")long id){
		return new ResponseEntity<User>(service.findById(id),HttpStatus.OK);
	}
	
//	@GetMapping(path="/userByEmail/{email}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<User> finduserbyEmail(@PathVariable(name="email")String email){
//		return new ResponseEntity<User>(service.findByEmail(email),HttpStatus.OK);
//	}
	
	@PostMapping(path="/user", produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addNewUser(@RequestBody User user){
		return new ResponseEntity<User>(service.addUser(user),HttpStatus.OK);
	}
	
	@PutMapping(path="/user/{id}", produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable(name="id")long id,@RequestBody User user){
		return new ResponseEntity<User>(service.update(id,user),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/user/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageRequest> deleteUserById(@PathVariable(name="id")long id,MessageRequest request){
		service.deleteUser(id);
		MessageRequest request1=new MessageRequest("the use with id "+id+" is deleted");
		return ResponseEntity.ok().body(request1);
	}
	
	//customer
	
	@GetMapping(path="/customer", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> findAllExistingCustomers(){
		return new ResponseEntity<List<Customer>>(custService.getAllcustomers(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/customer/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteExistingCustomers(@PathVariable(name="id")long id){
		custService.deleteCustomerById(id);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
	
//	//account
//	
//	@GetMapping(path="/account/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<AccountTransaction>> findAllExistingtransactions(){
//		return new ResponseEntity<List<AccountTransaction>>(accTranService.findAll(),HttpStatus.OK);
//	}
//	
//	@GetMapping(path="/account/{id}/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<AccountTransaction>> findAccountTransactions(@PathVariable(name="id")Long id){
//		return new ResponseEntity<List<AccountTransaction>>(accTranService.findByAccountAccountNumber(id),HttpStatus.OK);
//	}
//	
//	@PostMapping(path="/account", produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> addNewAccount(@RequestBody AccountRequest accountReq){
//		Customer customer=new Customer(accountReq.getName(), accountReq.getEmail(), accountReq.getPhone(), accountReq.getAddress(), accountReq.getCity(), accountReq.getCountry());
//		Account account=new Account(accountReq.getBalance(), false);
//		account.setCustomer(customer);
//		accService.createAccount(account);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	
	//transactionLog
	
	@GetMapping(path="/transactionLog",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> transactionLog(){
		return new ResponseEntity<List<TransactionLog>>(logService.findAll(),HttpStatus.OK);
	}
}
