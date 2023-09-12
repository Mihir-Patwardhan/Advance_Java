package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.DbConnection;
import com.pojo.Customer;
import com.pojo.Product;

public class CustomerDAO {
	private static Connection con;

	public CustomerDAO() {
		con = DbConnection.getConnection();
		System.out.println("---inside CustomerDAO Constr----");
	}

	public Customer validateCustomer(String username, String password) throws SQLException {

		String strSql = "select * from customer where username=? and password=?";
		System.out.println("---inside validate customer---" + username + "    " + password);
		PreparedStatement pstmt = con.prepareStatement(strSql);

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rset = pstmt.executeQuery();
		if (rset.next()) {
			System.out.println("--valid customer---");
			return new Customer( rset.getInt("cid"),rset.getString("cname"), rset.getString("city"),
					rset.getString("email"), rset.getString("username"), rset.getString("password"),rset.getString("role"));
		} else {
			System.out.println("invalid customer");
			return null;
		}
	}

	public int addNewCust(Customer obj) throws SQLException {

		System.out.println("customer"+obj);
		String sql = "insert into Customer(cname,city,email,username,password,role) values(?,?,?,?,?,'Customer')";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, obj.getCname());
		pstmt.setString(2, obj.getCity());
		pstmt.setString(3, obj.getEmail());
		pstmt.setString(4, obj.getUsername());
		pstmt.setString(5, obj.getPassword());

		int i = pstmt.executeUpdate();
		return i;

	}

}
