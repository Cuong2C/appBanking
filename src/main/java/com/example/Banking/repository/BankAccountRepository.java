package com.example.Banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Banking.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
