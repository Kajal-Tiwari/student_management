package com.capgemini.service;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
public interface Bank {
	boolean createAccount(Integer AccNo,Integer Deposit) throws InsufficientOpeningAmountException;
	boolean validateAccount(Integer AccNo)throws InvalidAccountNumberException; //Inputs Account no
	Integer depositAmount(Integer accNo,Integer amt); //Input Account no & Amount
	Integer withdrawAmount(Integer accNo,Integer amt) throws InsufficientBalanceException; //Input Account no & Amount
	Integer[] fundTransfer(Integer sourceAccNo,Integer recieverAccNo,Integer amt) throws InsufficientBalanceException; //Input Account no & Amount
	Integer checkBalance(Integer AccNo);
}
