package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbutil.DbConnection;
import com.pojo.Product;

public class ProductDAO {
	
	
	private Connection con;
	public ProductDAO()
	{
		con=DbConnection.getConnection();
		System.out.println("---inside ProdcutDAO constructer-----");
	
	}

	
	
	
	public ArrayList<Product> getAllProducts() throws SQLException
	{
		ArrayList<Product> allPrds=new ArrayList();//empty
		
		String sql="select * from product";
		System.out.println("---inside GetAllPrds----");
		Statement stmt=con.createStatement();
		
		ResultSet rset=stmt.executeQuery(sql);
		while(rset.next())
		{
			
			allPrds.add(new Product(rset.getInt("Pid"),
					 rset.getString("pname"),rset.getString("description"),
					 rset.getInt("price"),rset.getInt("quantity")));
			
		}
		return allPrds;	
	}
	
	public Product getPrdByName(String prdname) {
		System.out.println("----inside getPrdByName------"+prdname);
		String sql = "select * from product where pname=?";
		try
		{
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, prdname);
		
		ResultSet rset=pstmt.executeQuery();
		if(rset.next())
		{
			return new Product(rset.getInt("pid"),rset.getString("pname"),
					rset.getString("description"),rset.getInt("price"),rset.getInt("quantity"));
		}
		else
		{
			return null;
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;	
	}

}
