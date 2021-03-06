package com.capgemini.bankApp.service;

import java.util.List;

import com.capgemini.bankApp.entities.BankAccount;
import com.capgemini.bankApp.exceptions.LowBalanceException;

public interface BankAccountService {

	public double getBalance(long accountId);

	public double withdraw(long accountId, double amount) throws LowBalanceException;

	public double deposit(long accountId, double amount);

	public boolean fundTransfer(long fromAccount, long toAccount, double balance) throws LowBalanceException;

	public boolean addBankAccount(BankAccount account);

	public BankAccount findBankAccountById(long accountId);

	public List<BankAccount> finrAllBankAccounts();

	public BankAccount updateBankAccount(BankAccount account);

	public boolean deleteBankAccount(long accountId);

}
