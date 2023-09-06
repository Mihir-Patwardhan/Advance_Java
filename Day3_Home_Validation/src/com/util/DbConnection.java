package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getDbConnection() {
		try {
			// Step 1:Load Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("---Driver Loaded---");

			// specify where to Connect:

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "java");

			System.out.println("---connected---");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
