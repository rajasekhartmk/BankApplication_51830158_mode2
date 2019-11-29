package com.bankapp.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.bean.AccountCrBean;
import com.bankapp.web.controller.bean.AccountUpdateBean;
import com.bankapp.web.controller.bean.CreditDebitBean;
import com.bankapp.web.controller.bean.TransferBean;

@Controller
@RequestMapping("accountmgt/")
public class AccountController {

	@Autowired
	private AccountService service;
	
	@GetMapping("/")
	public String getAllAccounts(ModelMap map){
		map.addAttribute("accounts",service.findAll());
		return "allAccounts";
	}
	
	@GetMapping(path="addAccount")
	public String addAccount(ModelMap map){
		map.addAttribute("acc", new AccountCrBean());
		return "addAccount";
	}
	
	@PostMapping(path="addAccount")
	public String addAccountPost(@ModelAttribute(name="acc")AccountCrBean accountcreate,BindingResult bindingResult){
		if(bindingResult.hasErrors()==true)
			return "addAccount";
		Customer customer=new Customer(accountcreate.getName(), accountcreate.getEmail(), accountcreate.getPhone(), accountcreate.getAddress(), accountcreate.getCity(), accountcreate.getCountry());
		Account account=new Account(accountcreate.getBalance(), accountcreate.isBlocked());
		account.setCustomer(customer);
		service.createAccount(account);
		return "redirect:/";
	}
	
	@GetMapping(path="updateAccount")
	public String updateAccount(ModelMap map,@RequestParam long id){
		
		Account account=service.findByAccountNumber(id);

		AccountUpdateBean update=new AccountUpdateBean();
		update.setId(id);
		update.setBlocked(account.isBlocked());
		update.setEmail(account.getCustomer().getEmail());
		update.setPhone(account.getCustomer().getPhone());
		update.setAddress(account.getCustomer().getAddress());
		update.setCity(account.getCustomer().getCity());
		
		map.addAttribute("acc", update);
		return "updateAccount";
	}
	
	@PostMapping(path="updateAccount")
	public String updateAccountPost(ModelMap map,@ModelAttribute(name="acc")AccountUpdateBean account, BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return "updateAccount";
		long id=account.getId();
		Account updateAccount=service.findByAccountNumber(id);
		
		updateAccount.setBlocked(account.isBlocked());
		updateAccount.getCustomer().setEmail(account.getEmail());
		updateAccount.getCustomer().setPhone(account.getPhone());
		updateAccount.getCustomer().setAddress(account.getAddress());
		updateAccount.getCustomer().setCity(account.getCity());
		
		service.updateAccount(updateAccount, id);
		return "redirect:";
		
		
	}
	
	
	
	@GetMapping(path="delete")
	public String deleteAccount(HttpServletRequest req,@RequestParam long id){
		//long id=Long.parseLong(req.getParameter("accountNumber"));
		service.deleteAccountById(id);
		return "redirect:";
	}
	
	@GetMapping(path="deposit")
	public String depositGet(ModelMap map){
		map.addAttribute("deposit", new CreditDebitBean());
		return "deposit";
	}
	@PostMapping(path="deposit")
	public String depositPost(@ModelAttribute(name="deposit")CreditDebitBean bean){
		service.deposit(bean.getAccountNumber(), bean.getAmount());
		return "redirect:";
	}
	
	@GetMapping(path="withdrawl")
	public String withdrawlGet(ModelMap map){
		map.addAttribute("withdrawl", new CreditDebitBean());
		return "withdrawl";
	}
	@PostMapping(path="withdrawl")
	public String withdrawlPost(@ModelAttribute(name="withdrawl")CreditDebitBean bean){
		service.withdraw(bean.getAccountNumber(), bean.getAmount());
		return "redirect:";
	}
	
	@GetMapping(path="transfer")
	public String transferGet(ModelMap map){
		map.addAttribute("transfer", new TransferBean());
		return "transfer";
	}
	@PostMapping(path="transfer")
	public String transferPost(@ModelAttribute(name="transfer")TransferBean bean){
		service.transfer(bean.getFromAcc(), bean.getToAcc(), bean.getAmount());
		return "redirect:";
	}
	
	@ModelAttribute(name="blocked")
	public List<String> block(){
		return Arrays.asList("true","false");
	}
	
	
	
}
