package com.capgemini.service;
import java.util.LinkedList;
import com.capgemini.Exception.*;
import  com.capgemini.beans.*;
public class HDFCBank implements Bank{
	LinkedList <Account> accounts=new LinkedList<>();
    public String createAccount(int accountNumber,int amount) throws InsufficientOpeningAmountException {
    	Account account=new Account();
    	account.setAccountNumber(accountNumber);
    	account.setAmount(amount);
    	if(account.getAmount()>500) {
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
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			  return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
    }
    public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException {
    	Account account=searchAccount(accountNumber);
    	
    		account.setAmount(account.getAmount()+amount);
    		return account.getAmount(); 	
    }
    public int[] fundTransfer(int accountNumber1,int accountNumber2,int amount)throws InvalidAccountNumberException,InsufficientBalanceException {
    	{
    		Account account1=searchAccount(accountNumber1);
    		Account account2=searchAccount(accountNumber2);
    		if((account1.getAmount()-amount)>=0)
    		{
    			int[] a= {account1.getAmount()-amount,account2.getAmount()+amount};
    			account1.setAmount(account1.getAmount()-amount);
    			account2.setAmount(account2.getAmount()+amount);
    			return a;
    		}
    	
    	}
    	throw new InsufficientBalanceException();
    }
}
	