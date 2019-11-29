package com.bankapp.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.bean.AccountTransfer;
import com.bankapp.web.controller.bean.CreditDebitBean;
import com.bankapp.web.controller.bean.MessageRequest;

@RestController
@RequestMapping(path="/api")
public class CreditDebitController {

	@Autowired
	private AccountService accService;
	@Autowired
	private AccountRepository accrepo;
	
	@GetMapping(path="/transaction/account", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findAllExistingAccount(){
		return new ResponseEntity<List<Account>>(accrepo.findAll(),HttpStatus.OK);
	}
	
//	//GET METHODS
//	
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
//	@GetMapping(path="transfer/{fromAccNum}/{toAccNum}/{amount}",produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> transfer(@PathVariable(name="fromAccNum")long fromAccNum,@PathVariable(name="toAccNum")long toAccNum,@PathVariable(name="amount")double amount){
//		accService.transfer(fromAccNum, toAccNum, amount);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	
	//POST METHODS
	
	@PostMapping(path="/transaction/deposit", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageRequest> depositPost(@RequestBody CreditDebitBean bean,Principal principle,MessageRequest request){
		accService.deposit(bean.getAccNumber(), bean.getAmount(),principle.getName());
		MessageRequest request1=new MessageRequest("the account with acc num "+bean.getAccNumber()+" is credited with "+bean.getAmount());
		return ResponseEntity.ok().body(request1);
	}
	
	@PostMapping(path="/transaction/withdrawl", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageRequest> withDrawlPost(@RequestBody CreditDebitBean bean,Principal principle,MessageRequest request){
		accService.withdraw(bean.getAccNumber(), bean.getAmount(),principle.getName());
		MessageRequest request1=new MessageRequest("the account with acc num "+bean.getAccNumber()+" is debited with "+bean.getAmount());
		return ResponseEntity.ok().body(request1);
	}
	
	@PostMapping(path="/transaction/transfer",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageRequest> transferAmount(@RequestBody AccountTransfer transfer,Principal principle,MessageRequest request){
		accService.transfer(transfer.getFromAcc(), transfer.getToAcc(), transfer.getAmount(),principle.getName());
		MessageRequest request1=new MessageRequest(transfer.getAmount()+" is transfered from "+transfer.getFromAcc()+" to "+transfer.getToAcc());
		return ResponseEntity.ok().body(request1);
	}
}
