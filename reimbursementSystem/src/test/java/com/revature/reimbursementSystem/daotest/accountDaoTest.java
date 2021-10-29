package com.revature.reimbursementSystem.daotest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.revature.reimbursementSystem.dao.accountDao;
import com.revature.reimbursementSystem.dao.accountDaoImp;
import com.revature.reimbursementSystem.model.account;

public class accountDaoTest {
	private static accountDao adao = new accountDaoImp();

	@Test
	public void testgetAccountById1() {
		List<account> accounts = adao.getAllAccount();
		account newAccount = accounts.get(accounts.size() - 1);
		account result = adao.getAccountById(newAccount.getAccount_id());

		assertEquals(newAccount.getUsername(), result.getUsername());
	}

	@Test
	public void testgetAccountById2() {
		List<account> accounts = adao.getAllAccount();
		account newAccount = accounts.get(accounts.size() - 2);
		account result = adao.getAccountById(newAccount.getAccount_id());

		assertEquals(newAccount.getUsername(), result.getUsername());
	}

	@Test
	public void testgetAccountById3() {
		List<account> accounts = adao.getAllAccount();
		account newAccount = accounts.get(accounts.size() - 3);
		account result = adao.getAccountById(newAccount.getAccount_id());

		assertEquals(newAccount.getUsername(), result.getUsername());
	}

	@Test
	public void testgetAllAccount() {
		List<account> accounts = adao.getAllAccount();
		assertEquals(3, accounts.size());
	}

}
