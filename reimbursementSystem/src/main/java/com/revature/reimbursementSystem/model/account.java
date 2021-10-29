package com.revature.reimbursementSystem.model;

public class account {
	private int account_id;
	private String username;
	private String password;
	private int accounttype_id;

	public account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public account(int account_id, String username, String password, int accounttype_id) {
		super();
		this.account_id = account_id;
		this.username = username;
		this.password = password;
		this.accounttype_id = accounttype_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccounttype_id() {
		return accounttype_id;
	}

	public void setAccounttype_id(int accounttype_id) {
		this.accounttype_id = accounttype_id;
	}

	@Override
	public String toString() {
		return "account [account_id=" + account_id + ", username=" + username + ", password=" + password
				+ ", accounttype_id=" + accounttype_id + "]";
	}

}
