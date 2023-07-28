package com.example.Banking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Banking.entities.BankAccount;
import com.example.Banking.repository.BankAccountRepository;

@Service
public class BankService {

	@Autowired
	private BankAccountRepository repo;

	public List<BankAccount> getListBankAcount() {
		List<BankAccount> list = new ArrayList<>();
		for (BankAccount account : repo.findAll()) {
			list.add(account);
		}
		return list;
	}

	public BankAccount getById(int id) {
		return repo.findById(id).get();

	}

	public void addBankAccount(BankAccount e) {
		repo.save(e);

	}

	public void updateBankAccount(BankAccount e) {
		repo.save(e);
	}

	public void deleteBankAccount(int id) {
		repo.deleteById(id);
	}

	public void processSendMoney(int fromID, int toID, double amount) {
	    BankAccount from = getById(fromID);
	    BankAccount to = getById(toID);
	    double fromBalance = from.getBalance();
	    double toBalance = to.getBalance();
	    if (fromBalance >= amount) {
	        from.setBalance(fromBalance - amount);
	        to.setBalance(toBalance + amount);
	        updateBankAccount(from);
	        updateBankAccount(to);   
	    }
	}

}
