package com.capgemini.service;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repo.DBHelper;

public class HDFCBank implements Bank {
	
	DBHelper db=null;
	@Override
	public boolean createAccount(Integer accNo, Integer Deposit) throws InsufficientOpeningAmountException {
		Account a = new Account();
		if(new DBHelper().searchRecord(accNo))
		{
			
			return false;			
		}
		else 
		{
			a.setAccountNum(accNo);
			if(Deposit>=500)
			{
				a.setBalance(Deposit);
				return new DBHelper().insertRecord(a);
			}
			else
				throw new InsufficientOpeningAmountException();
		}
		
	}

	@Override
	public boolean validateAccount(Integer AccNo) throws InvalidAccountNumberException {
		
		if(new DBHelper().searchRecord(AccNo))
			return true;
		else	
			throw new InvalidAccountNumberException();
	}

	@Override
	public Integer depositAmount(Integer accNo, Integer amt) {
		
		Account a = new DBHelper().fetchRecord(accNo);
		a.setBalance(a.getBalance()+amt);
		if(new DBHelper().updateRecord(a))
			return a.getBalance();
		else
			return null;
	}

	@Override
	public Integer withdrawAmount(Integer accNo, Integer amt) throws InsufficientBalanceException {
		
		Account a = new DBHelper().fetchRecord(accNo);
		if(a.getBalance()-amt>=500)
		{
			a.setBalance(a.getBalance()-amt);
			if(new DBHelper().updateRecord(a))
				return a.getBalance();
			else
				return null;
		}

		throw new InsufficientBalanceException();
	}

	@Override
	public Integer[] fundTransfer(Integer sourceAccNo, Integer recieverAccNo, Integer amt)
			throws InsufficientBalanceException {
		Integer[] balance =null;
		Account sourceAcc = new DBHelper().fetchRecord(sourceAccNo);
		Account recieverAcc = new DBHelper().fetchRecord(recieverAccNo);
		if(sourceAcc.getBalance()-amt>=500)
		{
			sourceAcc.setBalance(sourceAcc.getBalance()-amt);
			recieverAcc.setBalance(recieverAcc.getBalance()+amt);
			if(new DBHelper().updateRecord(sourceAcc) && new DBHelper().updateRecord(recieverAcc))
			{
				balance =new Integer[] {sourceAcc.getBalance(),recieverAcc.getBalance()};
				return balance;
			}				
			else
				return null;
		}
			else
				throw new InsufficientBalanceException();
		
	}

	@Override
	public Integer checkBalance(Integer AccNo) {
		
		Account a = new DBHelper().fetchRecord(AccNo);
		return a.getBalance();
	}

}
