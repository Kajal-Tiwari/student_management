package com.capgemini.service;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
public class BankRunner implements Runnable {
	Bank bank;
	public BankRunner(Bank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		try {
			if(Thread.currentThread().getName().equals("first")) {


				System.out.println("After withdrawing amount in account no 101 is : "+bank.withdrawAmount(101,3000));

			}else {

				System.out.println("After withdrawing balance of account no 102 is: "+bank.withdrawAmount(102, 500));

			}
		}
		catch(InsufficientBalanceException inb) {
			System.out.println("insufficient balance");
		}catch(InvalidAccountNumberException ina) {
			System.out.println("invalid account number");
		}

	}

}
