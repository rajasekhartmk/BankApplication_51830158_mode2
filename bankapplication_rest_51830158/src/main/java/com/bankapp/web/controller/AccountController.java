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
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountTransactionService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.controller.bean.AccountRequest;
import com.bankapp.web.controller.bean.AccountUpdate;
import com.bankapp.web.controller.bean.MessageRequest;

@RestController
@RequestMapping(path="/api")
public class AccountController {

	@Autowired
	private CustomerService custService;
	@Autowired
	private AccountService accService;
	@Autowired
	private AccountRepository accrepo;
	@Autowired
	private AccountTransactionService accTranService;
	@Autowired
	private TransactionLogService logService;
	
	@GetMapping(path="/account", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findAllExistingAccount(){
		return new ResponseEntity<List<Account>>(accrepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/account/{accountNumber}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> findAccount(@PathVariable(name="accountNumber")long accountNumber){
		return new ResponseEntity<Account>(accService.findByAccountNumber(accountNumber),HttpStatus.OK);
	}
	
	@PostMapping(path="/account", produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageRequest> addNewAccount(@RequestBody AccountRequest accountReq,MessageRequest request){
		Customer customer=new Customer(accountReq.getName(), accountReq.getEmail(), accountReq.getPhone(), accountReq.getAddress(), accountReq.getCity(), accountReq.getCountry());
		Account account=new Account(accountReq.getBalance(), false);
		account.setCustomer(customer);
		accService.createAccount(account);
		MessageRequest request1=new MessageRequest("the account was added");
		return ResponseEntity.ok().body(request1);
	}
	
	@DeleteMapping(path="/account/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> deleteAccount(@PathVariable(name="id")long id){
		accService.deleteAccountById(id);
		return new ResponseEntity<List<Account>>(HttpStatus.OK);
	}
	
	@PutMapping(path="/account/{accountNumber}", produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAccount(@PathVariable(name="accountNumber")long accountNumber,@RequestBody AccountUpdate account){
		Account updateAccount=accService.findByAccountNumber(accountNumber);
		updateAccount.getCustomer().setEmail(account.getEmail());
		updateAccount.getCustomer().setPhone(account.getPhone());
		updateAccount.getCustomer().setAddress(account.getAddress());
		updateAccount.getCustomer().setCity(account.getCity());
		accService.updateAccount(updateAccount, accountNumber);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@GetMapping(path="/account/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTransaction>> findAllExistingtransactions(){
		return new ResponseEntity<List<AccountTransaction>>(accTranService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/account/{id}/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTransaction>> findAccountTransactions(@PathVariable(name="id")Long id){
		return new ResponseEntity<List<AccountTransaction>>(accTranService.findByAccountAccountNumber(id),HttpStatus.OK);
	}
	
	
	
	
	
	
//	@GetMapping(path="/account/{accountNumber}/deposit/{amount}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> deposit(@PathVariable(name="accountNumber")long accountNumber,@PathVariable(name="amount")double amount){
//		accService.deposit(accountNumber, amount);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
//	
//	@GetMapping(path="/account/{accountNumber}/withdrawl/{amount}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> withDrawl(@PathVariable(name="accountNumber")long accountNumber,@PathVariable(name="amount")double amount){
//		accService.withdraw(accountNumber, amount);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
//	
//	@GetMapping(path="/transfer/{fromAccNum}/{toAccNum}/{amount}",produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> transfer(@PathVariable(name="fromAccNum")long fromAccNum,@PathVariable(name="toAccNum")long toAccNum,@PathVariable(name="amount")double amount){
//		accService.transfer(fromAccNum, toAccNum, amount);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	
}
