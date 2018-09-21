package com.capgemini.bankApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.bankApp.config.AppConfig;
import com.capgemini.bankApp.controller.BankAccountController;
import com.capgemini.bankApp.entities.BankAccount;

public class Application {
	public static void main(String args[]) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
		
//		BankAccountController bankAccountController2 = context.getBean("bankAccountController",
//				BankAccountController.class);
//		System.out.println(bankAccountController.hashCode()+"\t"+bankAccountController2.hashCode());
		
//		context.getBean(BankAccountController.class);  - 
		


//		System.out.println(bankAccountController.getBalance(12343));
//		try {
//
//			System.out.println(bankAccountController.getBalance(12344));
//			System.out.println(bankAccountController.withdraw(12344, 1000));
//			System.out.println(bankAccountController.getBalance(12344) + "\t" + bankAccountController.getBalance(12344));
//			bankAccountController.fundTransfer(12344, 12343, 1000);
//			System.out.println(bankAccountController.getBalance(12344) + "\t" + bankAccountController.getBalance(12343));
//		} catch (LowBalanceException e) {
//			e.printStackTrace();
//		}
//		System.out.println(bankAccountController.deposit(12345, 5000));
//		System.out.println(bankAccountController.findBankAccountById(12344));

		BankAccount account = new BankAccount(12346,"Sam","CURRENT",25000);
//		System.out.println(bankAccountController.addBankAccount(account));
		System.out.println(bankAccountController.deleteBankAccount(12346));
		System.out.println(bankAccountController.finrAllBankAccounts());
//		System.out.println(bankAccountController.findBankAccountById(12346));
//		BankAccount account = new BankAccount(12344,"Marry","SAVINGS",40000);
//		System.out.println(bankAccountController.updateBankAccount(account));
	}
}
