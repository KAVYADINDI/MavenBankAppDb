package com.capgemini.bankApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankApp.entities.BankAccount;
import com.capgemini.bankApp.exceptions.LowBalanceException;
import com.capgemini.bankApp.repository.BankAccountRepository;
import com.capgemini.bankApp.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public double getBalance(long accountId) {
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance >= 0) {
			if (balance - amount >= 0) {
				bankAccountRepository.updateBalance(accountId, balance - amount);
				return bankAccountRepository.getBalance(accountId);
			} else
				throw new LowBalanceException("You Dont Have sufficient balance");
		}
		return -1;
	}

	@Override
	public double deposit(long accountId, double amount) {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance >= 0) {
			bankAccountRepository.updateBalance(accountId, balance + amount);
			return bankAccountRepository.getBalance(accountId);
		}
		return balance;
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException {
		double balance = withdraw(fromAccount, amount);
		if (balance != -1) {
			if (deposit(toAccount, amount) == -1) {
				deposit(fromAccount, amount);
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean addBankAccount(BankAccount account) {
		return bankAccountRepository.addBankAccount(account);
	}

	@Override
	public BankAccount findBankAccountById(long accountId) {
		return bankAccountRepository.findBankAccountById(accountId);
	}

	@Override
	public List<BankAccount> finrAllBankAccounts() {
		return bankAccountRepository.finrAllBankAccounts();
	}

	@Override
	public BankAccount updateBankAccount(BankAccount account) {
		return bankAccountRepository.updateBankAccount(account);
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		return bankAccountRepository.deleteBankAccount(accountId);
	}
}
