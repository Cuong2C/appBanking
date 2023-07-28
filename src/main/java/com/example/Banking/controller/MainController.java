package com.example.Banking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Banking.entities.BankAccount;
import com.example.Banking.service.BankService;

@RestController
public class MainController {
	List<BankAccount> list = new ArrayList<>();
	
	@Autowired
	private BankService service;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
	
	@GetMapping("/send")
	public ModelAndView sendMoney() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("send");
	    return modelAndView;
	}
	
	@GetMapping("/error")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
	
	@GetMapping("/account")
	public List<BankAccount> listBankAccount(){
		return service.getListBankAcount();
	}
	
	@GetMapping("/account/{id}")
	public BankAccount getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("/account")
	public void addBankAccount(@RequestBody BankAccount e) {
		service.addBankAccount(e);
	}
	
	@PutMapping("/account/{id}")
	public void updateBankAccount(@RequestBody BankAccount e) {
		service.updateBankAccount(e);
	}
	
	@DeleteMapping("/account/{id}")
	public void deleteBankAccount(@PathVariable int id) {
		service.deleteBankAccount(id);
	}
	
	
	@PostMapping("/sendMoney")
	public ModelAndView processSendMoney(@RequestParam("fromID") int fromID, @RequestParam("toID") int toID, @RequestParam("amount") double amount) {
	    List<BankAccount> list = service.getListBankAcount();
	    if (isValidTransaction(fromID, toID, amount, list)) {
	        service.processSendMoney(fromID, toID, amount);
	        return new ModelAndView("redirect:/");
	    }
	    return new ModelAndView("redirect:/error");
	}

	private boolean isValidTransaction(int fromID, int toID, double amount, List<BankAccount> list) {
	    boolean isValid = true;
	    if (fromID < 1 || fromID > list.size() || toID < 1 || toID > list.size()) {
	        isValid = false;
	    } else if (fromID == toID) {
	        isValid = false;
	    } else if (amount <= 0) {
	        isValid = false;
	    }
	    return isValid;
	}
	
}
