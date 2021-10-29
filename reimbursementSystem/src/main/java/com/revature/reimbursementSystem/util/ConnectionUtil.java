package com.revature.reimbursementSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://revature.cxeie1v1zcsc.us-east-2.rds.amazonaws.com/", "postgres", "postgres");
		return conn;
	}

}