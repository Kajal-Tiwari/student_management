package com.capgemini.repo;

import com.capgemini.model.Account;

public interface DBInterface {

	boolean searchRecord(int accNo);

	boolean insertRecord(Account a);

	Account fetchRecord(int accNo);

	boolean updateRecord(Account a);

}