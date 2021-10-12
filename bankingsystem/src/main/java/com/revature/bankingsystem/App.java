package com.revature.bankingsystem;

import java.io.Console;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.bankingsystem.dao.BankingDAO;

public class App {
	public static Scanner get = new Scanner(System.in);
	public static Console console = System.console();// to hide password when input from cmd
	
	public static void newUser() throws Exception {//(sign in)adding new user
		String userName;
		String userPassword;
		System.out.println("\n\nThanks for choosing our bank");
		System.out.println("Please input your username");
		userName = console.readLine();
		if (BankingDAO.checkUserName(userName)) {// to avoid the user name duplicates
			System.out.println("Username already exists, please try to login or choose another username.");
			return;
		} else {
			while (true) {
				System.out.println("Please input your password");
				// confirmed password need to be check
				char[] password = console.readPassword();
				userPassword = String.valueOf(password);
				System.out.println("Please input your password again to confirmed");
				password = console.readPassword();
				if (!userPassword.equals(String.valueOf(password))) {
					System.out.println("Password not match, please input again");
					continue;
				}
				if (BankingDAO.insert(userName, userPassword) != 0) {
					System.out.println("user created, please log in.");
					return;
				}
			}
		}
	}

	public static boolean login() throws Exception {//method for user login with username and password
		String userName;
		String userPassword;
		System.out.println("\n\nPlease input your username");
		// userName = get.next();
		userName = console.readLine();
		System.out.println("Please input your password");
		// userPassword = get.next();
		char[] password = console.readPassword();
		userPassword = String.valueOf(password);
		return BankingDAO.loginById(userName, userPassword);
	}

	public static void addAccount() throws Exception {//user adding different types of account
		System.out.println("\n\nPlease choose your new account type");
		System.out.println(" \t\t 1) Checking Account  ");
		System.out.println(" \t\t 2) Savings Account ");
		System.out.println(" \t\t 3) Money Market Account ");
		System.out.println(" \t\t 4) Certificate of Deposit");
		try {
			int accountType = get.nextInt();
			if (accountType <= 0 || accountType > 4) {
				System.err.println("Please enter your choice [1-4]");
				return;
			}
			if (BankingDAO.addAccount(accountType) != 0) {
				System.out.println("New account added");
			}
		} catch (InputMismatchException e) {
			System.err.println("Please enter your choice [1-4]");
			get.next();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void deposit() throws Exception {//choose an account to make a deposit
		System.out.println("\n\nPlease choose an account you want to deposit");
		System.out.println(" \t\t 1) Checking Account  ");
		System.out.println(" \t\t 2) Savings Account ");
		System.out.println(" \t\t 3) Money Market Account ");
		System.out.println(" \t\t 4) Certificate of Deposit");
		try {
			int accountType = get.nextInt();
			if (accountType < 1 || accountType > 5) {
				System.err.println("Please enter your choice [1-4].");
				return;
			}
			if (BankingDAO.getAccountId(accountType)!=0) {
				System.out.println("Pleas type amount: ");
				double depositAmount = get.nextDouble();
				BankingDAO.deposit(accountType, depositAmount);
			}
		} catch (InputMismatchException e) {
			System.err.println("Please enter your choice [1-4] and type correct format(decimal).");
			get.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void withdraw() throws Exception {//choose an account to make a withdraw
		System.out.println("\n\nPlease choose an account you want to withdraw");
		System.out.println(" \t\t 1) Checking Account  ");
		System.out.println(" \t\t 2) Savings Account ");
		System.out.println(" \t\t 3) Money Market Account ");
		System.out.println(" \t\t 4) Certificate of Deposit");
		try {
			int accountType = get.nextInt();
			if (accountType < 1 || accountType > 5) {
				System.err.println("Please enter your choice [1-4].");
				return;
			}
			if(BankingDAO.getAccountId(accountType)!=0) {
				System.out.println("Pleas type amount: ");
				Double withdrawAmount = get.nextDouble();
				BankingDAO.withdraw(accountType, withdrawAmount);
			}
		} catch (InputMismatchException e) {
			System.err.println("Please enter your choice [1-4] and type correct format(decimal)");
			get.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}

	}

	public static void showTransactionRecord() throws Exception {//choose an account to display transaction record
		System.out.println("\n\nPlease choose an account type to get transaction record");
		System.out.println(" \t\t 1) Checking Account  ");
		System.out.println(" \t\t 2) Savings Account ");
		System.out.println(" \t\t 3) Money Market Account ");
		System.out.println(" \t\t 4) Certificate of Deposit");
		try {
			int accountType = get.nextInt();
			if (accountType <= 0 || accountType > 4) {
				System.err.println("Please enter your choice [1-4]");
				return;
			}
			BankingDAO.getTransactionRecord(accountType);
		} catch (InputMismatchException e) {
			System.err.println("Please enter your choice [1-4]");
			get.next();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void viewAccounts() throws Exception {
		System.out.println("\n\n");
		BankingDAO.getAccountInfo();
	}

	public static void main(String[] args) throws Exception {
		int choice = 0;
		BankingDAO.connect();
		while (choice >= 0) {
			System.out.println("\n\n");
			System.out.println(" \t\t 1) New User  ");
			System.out.println(" \t\t 2) Login ");
			System.out.println(" \t\t 3) Exit ");
			System.out.println("Enter your choice [1-3]");
			try {
				choice = get.nextInt();
				switch (choice) {
				case 1:
					newUser();
					break;
				case 2:
					boolean loginStatus = login();
					while (choice > 0 && loginStatus) {
						System.out.println("\n\n");
						System.out.println(" \t\t 1) add an account ");
						System.out.println(" \t\t 2) make a deposit ");
						System.out.println(" \t\t 3) make a withdraw ");
						System.out.println(" \t\t 4) show transaction records");
						System.out.println(" \t\t 5) view accounts");
						System.out.println(" \t\t 6) log out");
						System.out.println("Enter your choice [1-6]");
						try {
							choice = get.nextInt();
							switch (choice) {
							case 1:
								addAccount();
								break;
							case 2:
								deposit();
								break;
							case 3:
								withdraw();
								break;
							case 4:
								showTransactionRecord();
								break;
							case 5:
								viewAccounts();
								break;
							case 6:
								System.out.println("You have logged out");
								loginStatus = false;
								break;
							default:
								System.out.println("Please Enter any value between 1 to 7");
								break;
							}
						} catch (InputMismatchException e) {
							System.err.println("Please enter your choice [1-7]");
							get.next();
							continue;
						} catch (Exception e) {
							continue;
						}
					}
					break;
				case 3:
					BankingDAO.closeResource();
					System.out.println("Thanks for using our banking system!");
					System.exit(0);
					break;
				default:
					System.out.println("Please Enter any value between 1 to 6");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Please enter your choice [1-3]!");
				get.next();
				continue;
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		get.close();
	}
	
}