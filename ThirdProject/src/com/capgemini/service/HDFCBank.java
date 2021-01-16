package com.capgemini.service;
import java.util.LinkedList;

import  com.capgemini.beans.*;
import com.capgemini.exception.*;
public class HDFCBank implements Bank{
	private LinkedList <Account> accounts=new LinkedList<>();
	public String createAccount(int accountNumber,int amount) throws InsufficientOpeningAmountException {
		Account account=new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		if(account.getAmount()>=500) {
			accounts.add(account);
			return"account created successfully";
		}else {
			throw new InsufficientOpeningAmountException();
		}

	}
	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException {
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		Account account=searchAccount(accountNumber);
		synchronized(account){
			if((account.getAmount()-amount)>=500)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				account.setAmount(account.getAmount()-amount);
				return account.getAmount();
			}

			throw new InsufficientBalanceException();
		}
	}
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException {
		Account account=searchAccount(accountNumber);

		account.setAmount(account.getAmount()+amount);
		return account.getAmount(); 	

	}
	public int[] fundTransfer(int senderAccount,int receiverAccount,int amount)throws InvalidAccountNumberException,InsufficientBalanceException {
		{
			Account sender=searchAccount(senderAccount);
			Account receiver=searchAccount(receiverAccount);

			if((sender.getAmount()-amount)>=0)
			{
				sender.setAmount(sender.getAmount()-amount);
				receiver.setAmount(receiver.getAmount()+amount);
				int[] transfer= {sender.getAmount(),receiver.getAmount()};
				return transfer;
			}    	
		}
		throw new InsufficientBalanceException();
	}
}
