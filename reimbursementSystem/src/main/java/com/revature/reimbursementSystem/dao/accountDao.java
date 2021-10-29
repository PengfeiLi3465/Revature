package com.revature.reimbursementSystem.dao;

import java.util.List;

import com.revature.reimbursementSystem.model.account;

public interface accountDao {
	
	account getAccountById(int account_id);

	List<account> getAllAccount();
}
