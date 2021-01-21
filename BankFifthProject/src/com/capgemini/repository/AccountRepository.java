package com.capgemini.repository;

import com.capgemini.beans.Account;

public interface AccountRepository {
	boolean save(Account account);
	Account searchAccount(int accountNumber);
}
