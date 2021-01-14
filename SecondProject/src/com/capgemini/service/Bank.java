package com.capgemini.service;
import com.capgemini.Exception.*;

public interface Bank {
	String createAccount(int accountNumber,int amount)throws InsufficientOpeningAmountException;
	int withdrawAmount(int accountNumber, int amount)throws InvalidAccountNumberException, InsufficientBalanceException;
	int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;
	int[] fundTransfer(int accountNumber1,int accountNumber2,int amount)throws InvalidAccountNumberException,InsufficientBalanceException;
    	
}
