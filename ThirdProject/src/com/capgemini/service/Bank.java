package com.capgemini.service;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
public interface Bank {
	String createAccount(int accountNumber,int amount)throws InsufficientOpeningAmountException;
	int withdrawAmount(int accountNumber, int amount)throws InvalidAccountNumberException, InsufficientBalanceException;
	int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;
	int[] fundTransfer(int senderAccount,int receiverAccount,int amount)throws InvalidAccountNumberException,InsufficientBalanceException;

}
