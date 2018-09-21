package com.capgemini.bankApp.repository;

import java.util.List;

import com.capgemini.bankApp.entities.BankAccount;

public interface BankAccountRepository {

	public double getBalance(long accountId);

	public boolean updateBalance(long accountId, double newBalance);

	public boolean addBankAccount(BankAccount account);

	public BankAccount findBankAccountById(long accountId);

	public List<BankAccount> finrAllBankAccounts();

	public BankAccount updateBankAccount(BankAccount account);

	public boolean deleteBankAccount(long accountId);
}
