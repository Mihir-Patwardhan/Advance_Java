package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("---driver loaded----");
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/test", "root", "root");

			 
			System.out.println("Connected to MySql....");
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}
