package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDAO;
import com.pojo.Customer;
import com.pojo.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	ProductDAO prdDAO;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("\n-----init  ProductServlet-----");
		prdDAO = new ProductDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		Customer validCust = (Customer) session.getAttribute("custobj");
		pw.write("<br>Welcome Customer:" + validCust.getCname());
		pw.write("<center><h2>Welcome To Shopping Page</h2>");
		System.out.println("---session created for valid cust----");
		session.setAttribute("prdDAO", prdDAO);
		pw.write("<br>Available Products:");
		try {
			ArrayList<Product> allPrds = prdDAO.getAllProducts();
			System.out.println(allPrds);
			// Dynamic HTML
			
			pw.write("<form action='showdetails'> <table bgcolor='white' border='1'>");
			pw.write("<tr>");
			pw.write("<td>PId</td>");
			pw.write("<td>PName</td>");
			pw.write("<td>Price</td>");
			pw.write("<td>Quantity</td>");
			pw.write("</tr>");
			for (Product p : allPrds) {
				pw.write("<tr>");
				pw.write("<td>" + p.getPid() + "</td>");
				pw.write("<td>" + p.getPname() + "</td>");
				pw.write("<td>" + p.getPrice() + "</td>");
				pw.write("<td>" + p.getQuantity() + "</td>");
				pw.write("<td><input type='radio' name='radioval' value='" + p.getPname() + "'></td>");
				pw.write("</tr>");
			}
			pw.write("</table>");
			pw.write("<br>");
			pw.write("<td><input type='submit' value='Show Details'></td>");
			pw.write("</center></form>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
