package com.dal;

import java.sql.*;
import com.pojo.Details;
import com.util.DbConnection;

public class BankDal {
	private static Connection con;

	static {
		System.out.println("----Testing Connection---");
		con = DbConnection.getDbConnection();
	}

	public Details Validate(String username, String password) {
		//
		try {
			System.out.println("----inside validate account-----" + username + "   " + password);
			String str = "select * from bankAccount where username=? and password=?";

			PreparedStatement pstmt = con.prepareStatement(str);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				System.out.println("---valid account---");
				Details acc1 = new Details(rset.getInt("actid"), rset.getString("name"), rset.getInt("balance"),
						rset.getString("username"), rset.getString("password"));
				return acc1;
			} else {
				System.out.println("---invalid account---");
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	return null;
	}
}
