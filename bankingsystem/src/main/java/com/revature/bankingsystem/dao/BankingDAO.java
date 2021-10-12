package com.revature.bankingsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankingDAO {
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStmt = null;
	private static ResultSet result = null;
	private static int userId;

	public static void connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "root");
	}

	public static int addAccount(int typeId) throws SQLException {
		int addStatus = 0;
		String checkQuery = "SELECT user_id FROM account WHERE accounttype_id='" + typeId + "' AND user_id = '"+userId+"';";
		// check an account type for this user exists or not
		statement = connection.createStatement();
		result = statement.executeQuery(checkQuery);
		if (userId != 0 && !result.next()) {//if not exists, then we can add this type of account to this user
			String insertQuery = "INSERT INTO account (`user_id`,`accounttype_id`,`account_balance`) VALUES (?,?,?);";
			preparedStmt = connection.prepareStatement(insertQuery);
			preparedStmt.setInt(1, userId);
			preparedStmt.setInt(2, typeId);
			preparedStmt.setInt(3, 0);
			addStatus = preparedStmt.executeUpdate();
		} else {
			System.out.println("You already has an account, please choose another type.");
		}
		return addStatus;
	}
	
	public static boolean checkUserName(String userName) throws Exception{
		//check the database to make sure there is no duplicate username
		boolean checkStatus = false;
		String query = "SELECT user_id FROM user WHERE user_name='" + userName + "';"; // creating a query
		statement = connection.createStatement();
		result = statement.executeQuery(query);
		if(result.next()) checkStatus = true;
		return checkStatus;
	}

	public static int insert(String userName, String userPassword) throws Exception {
		//method to insert a new user (sign in)
		int insertStatus = 0;
		if (checkUserName(userName)) {
			System.out.println("Username already in used, please try to login or use another username.");
			return insertStatus;//check to avoid the user name duplicate
		} else {
			String insertQuery = "INSERT INTO user (`user_name`,`user_password`) VALUES (?,?);";
			preparedStmt = connection.prepareStatement(insertQuery);
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, userPassword);
			insertStatus = preparedStmt.executeUpdate();
			return insertStatus;
		}
	}
	
	public static int getAccountId(int accountTypeId) throws SQLException {
		//using userId and the typeId to get accountId from database 
		int accountId=0;
		String query = "SELECT account_id FROM account WHERE user_id='" + userId + "' AND accounttype_id='" + accountTypeId
				+ "';";
		statement = connection.createStatement();
		result = statement.executeQuery(query);
		if (result.next()) {
			accountId = result.getInt("account_id");
		} else
			System.out.println("Sorry, you don't have this type of account please add an account first.");

		return accountId;
	}
	
	public static int insertTransactionRecord(int accountId, int transactionTypeId, double depositAmount) throws SQLException {
		//insert transaction record to transaction record table
		int insertTransactionStatus = 0;
		String insertTransactionQuery = "INSERT INTO transactionrecord (`account_id`,`transaction_type`,`transaction_amount`,`transaction_date`) VALUES (?,?,?,now());";
		preparedStmt = connection.prepareStatement(insertTransactionQuery);
		preparedStmt.setInt(1,accountId);
		preparedStmt.setInt(2,transactionTypeId);
		preparedStmt.setDouble(3, depositAmount);
		insertTransactionStatus = preparedStmt.executeUpdate();
		return insertTransactionStatus;
	}
	
	public static void getTransactionRecord(int accountTypeId) throws SQLException {
		//get transaction record from database for the account type that user choosed
		int accountId = getAccountId(accountTypeId);
		//we only ask for account type so we need to find accountid first
		String query = "SELECT a.transactiontype_name, b.transaction_amount, b.transaction_date FROM transactiontype a INNER JOIN transactionrecord b ON a.transactiontype_id = b.transaction_type WHERE b.account_id = "+accountId+" ORDER BY b.transaction_date;"; 
		statement = connection.createStatement();
		result = statement.executeQuery(query);
		//get transaction record for this account
		System.out.println("Type"+"\t\t"+"Amount"+"\t\t"+"Date");
		while (result.next()) {
			System.out.println(result.getString("transactiontype_name") + " \t" + result.getDouble("transaction_amount") + " \t\t" + result.getDate("transaction_date")+" "+result.getTime("transaction_date"));
		}
		return;
	}
	
	public static double getBalance(int accountTypeId) throws SQLException {
		//get account balance through accounttypeid and userid
		double balance=0;
		String query = "SELECT account_balance FROM account WHERE user_id='" + userId + "' AND accounttype_id='" + accountTypeId
				+ "';";
		statement = connection.createStatement();
		result = statement.executeQuery(query);
		if (result.next()) {
			
			balance = result.getDouble("account_balance");
		}
		return balance;
	}
	
	public static int withdraw(int accountTypeId, double withdrawAmount) throws Exception {
		if(withdrawAmount<=0) {
			System.out.println("Please enter a positive number");
			return 0;	
		}//make sure there is no negative transaction amount
		if (userId != 0) {
			int withdrawStatus = 0;
			double newBalance =getBalance(accountTypeId)-withdrawAmount;
			//calculate new balance first, if negative than warning no sufficient balance
			if(newBalance>=0) {
				String withdrawQuery = "UPDATE account SET account_balance = " + newBalance
						+ " WHERE accounttype_id = " + accountTypeId + " AND user_id = " + userId + ";"; // creating a query
				preparedStmt = connection.prepareStatement(withdrawQuery); // creating prepared Statement
				withdrawStatus = preparedStmt.executeUpdate();
				if(withdrawStatus != 0) {
					System.out.println("Withdraw successed");
					insertTransactionRecord(getAccountId(accountTypeId),2,withdrawAmount);
					//transaction record insert when withdraw successes.
					return withdrawStatus;
				}else {
					System.out.println("Deposit failed, please check your account type");
					return withdrawStatus;
				}
			}else {
				System.out.println("Withdraw failed, no sufficient balance.");
				return withdrawStatus;
			}
		} else {
			return 0;
		}
	}
	
	public static int deposit(int accountTypeId, double depositAmount) throws Exception {
		//make sure there is no negative transaction record;
		if(depositAmount<=0) {
			System.out.println("Please enter a positive number");
			return 0;
		}
		if (userId != 0) {
			int depositStatus = 0;
			String depositQuery = "UPDATE account SET account_balance = account_balance+" + depositAmount
					+ " WHERE accounttype_id = " + accountTypeId + " AND user_id = " + userId + ";"; // creating a query
			preparedStmt = connection.prepareStatement(depositQuery); // creating prepared Statement
			depositStatus = preparedStmt.executeUpdate();
			if (depositStatus != 0) {
				System.out.println("Deposit successed");
				insertTransactionRecord(getAccountId(accountTypeId),1,depositAmount);
				//transaction record insert when deposit successes.
				return depositStatus;
			} else {
				System.out.println("Deposit failed, please check your account type");
				return depositStatus;
			}
		} else {
			return 0;
		}
	}

	public static void getAccountInfo() throws Exception{
		//display every account's balance for the user
		String query = "SELECT a.accounttype_name, b.account_balance FROM accounttype a INNER JOIN account b WHERE a.accounttype_id = b.accounttype_id AND b.user_id = "+userId+";";
		statement = connection.createStatement();
		result = statement.executeQuery(query);
		System.out.println("Type"+"\t\t\t"+"Balance");
		while (result.next()) {
			System.out.println(result.getString("accounttype_name") + " \t" + result.getDouble("account_balance"));
		}
		return;
	}

	public static boolean loginById(String userName, String userPassword) throws Exception {
		//user login method
		String query = "SELECT user_id FROM user WHERE user_name='" + userName + "' AND user_password='" + userPassword
				+ "';"; // creating a query
		statement = connection.createStatement();
		boolean loginStatus = false;
		result = statement.executeQuery(query);
		if (result.next()) {
			userId = result.getInt("user_id");
			loginStatus = true;
			System.out.println("Login success! Hello "+userName+" !");
		} else
			System.out.println("Login failed, please check your name and password.");
		return loginStatus;
	}

	public static void closeResource() throws Exception {
		if (result != null) {
			result.close();
		}
		if (preparedStmt != null) {
			preparedStmt.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}