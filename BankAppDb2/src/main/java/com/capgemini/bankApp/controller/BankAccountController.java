package com.capgemini.bankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankApp.entities.BankAccount;
import com.capgemini.bankApp.exceptions.LowBalanceException;
import com.capgemini.bankApp.service.BankAccountService;
@Controller
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;

	public double getBalance(long accountId) {
		return bankAccountService.getBalance(accountId);
	}

	public double withdraw(long accountId, double amount) throws LowBalanceException {
		return bankAccountService.withdraw(accountId, amount);
	}

	public double deposit(long accountId, double amount) {
		return bankAccountService.deposit(accountId, amount);
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException {
		return bankAccountService.fundTransfer(fromAccount, toAccount, amount);
	}
	
	public boolean addBankAccount(BankAccount account) {
		return bankAccountService.addBankAccount(account);
	}

	public BankAccount findBankAccountById(long accountId) {
		return bankAccountService.findBankAccountById(accountId);
	}

	public List<BankAccount> finrAllBankAccounts() {
		return bankAccountService.finrAllBankAccounts();
	}

	public BankAccount updateBankAccount(BankAccount account) {
		return bankAccountService.updateBankAccount(account);
	}
	
	public boolean deleteBankAccount(long accountId) {
		return bankAccountService.deleteBankAccount(accountId);
	}

}
