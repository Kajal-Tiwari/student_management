package com.capgemini.test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsuffientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImplementation;

public class AccountTest {
		AccountService accountService;
		public static Account account = new Account();		
		@Mock
		AccountRepository accountRepository;
		
		@Before
		public void setUp() throws Exception {
			MockitoAnnotations.initMocks(this);
			
			accountService = new AccountServiceImplementation(accountRepository);
		}
		
		
		@Test(expected=com.capgemini.exceptions.InsuffientOpeningAmountException.class)
		public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsuffientOpeningAmountException
		{
			accountService.createAccount(101, 400);
		}
		
		@Test
		public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsuffientOpeningAmountException
		{
			account =new Account(101,5000);
			when(accountRepository.save(account)).thenReturn(true);
			assertEquals(account, accountService.createAccount(101, 5000));
		}
		
		@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
		public void whenTheAccountNumberIsInvalidDuringDepositSystemShouldThrowException() throws InvalidAccountNumberException,InsuffientOpeningAmountException
		{
			accountService.depositAmount(101, 2000);
		}
		@Test
		public void whenTheValidInfoIsPassedAmountShouldBeDeposited() throws InvalidAccountNumberException, InsufficientBalanceException,InsuffientOpeningAmountException
		{	
			account = new Account(101,600);
			when(accountRepository.searchAccount(101)).thenReturn(account);
			assertEquals(account, accountService.depositAmount(101, 5000));
		}
		@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
		public void whenTheAccountNumberIsInvalidDuringWithdrawSystemShouldThrowException() throws InvalidAccountNumberException, InsufficientBalanceException, InsuffientOpeningAmountException
		{
			accountService.withdrawAmount(100, 2000);
		}
		@Test(expected=com.capgemini.exceptions.InsufficientBalanceException.class)
		public void whenTheAmountWithdrawnIsMoreThanCurrentBalanceSystemShouldThrowException() throws InvalidAccountNumberException, InsufficientBalanceException, InsuffientOpeningAmountException
		{
			account = new Account(101,700);
			when(accountRepository.searchAccount(101)).thenReturn(account);
			accountService.withdrawAmount(101, 800);
		}
		@Test
		public void whenTheValidInfoIsPassedAmountShouldBeWithdrawn() throws InvalidAccountNumberException, InsufficientBalanceException,InsuffientOpeningAmountException
		{
			account = new Account(101, 600);
			when(accountRepository.searchAccount(101)).thenReturn(account);
			assertEquals(account, accountService.withdrawAmount(101, 300));
		}
	}



	
	
	
	
