package com.revature.reimbursementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.reimbursementSystem.model.account;
import com.revature.reimbursementSystem.util.ConnectionUtil;

public class accountDaoImp implements accountDao {
	private static Logger log = LoggerFactory.getLogger(accountDaoImp.class);

	@Override
	public account getAccountById(int account_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM public.account WHERE account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account_id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			account newAccount = new account();
			newAccount.setAccount_id(account_id);
			newAccount.setAccounttype_id(rs.getInt("accounttype_id"));
			newAccount.setPassword(rs.getString("password"));
			newAccount.setUsername(rs.getString("username"));
			log.info("get account by accountId");
			return newAccount;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<account> getAllAccount() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM public.account";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<account> accounts = new ArrayList<account>();
			while (rs.next()) {
				account newAccount = new account();
				newAccount.setAccount_id(rs.getInt("account_id"));
				newAccount.setAccounttype_id(rs.getInt("accounttype_id"));
				newAccount.setPassword(rs.getString("password"));
				newAccount.setUsername(rs.getString("username"));

				accounts.add(newAccount);
				log.info("get all accounts");
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
