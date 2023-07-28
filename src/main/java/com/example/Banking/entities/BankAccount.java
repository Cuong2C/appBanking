package com.example.Banking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_account")
public class BankAccount {
	
		@Id
		@GeneratedValue
		@Column(name="id")
		private int id;
		@Column(name="full_name")
		private String fullName;
		@Column(name="balance")
		private double balance;
		
		
		public BankAccount() {
		}
		
		public BankAccount(int id, String fullName, double balance) {
			super();
			this.id = id;
			this.fullName = fullName;
			this.balance = balance;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "BankAccount [id=" + id + ", fullName=" + fullName + ", balance=" + balance + "]";
		}

}
