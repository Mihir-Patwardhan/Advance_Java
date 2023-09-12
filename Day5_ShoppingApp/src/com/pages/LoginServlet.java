package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDAO;
import com.pojo.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	CustomerDAO customerDao;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("---inside init LoginServlet----");
		customerDao = new CustomerDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("----doGet LoginServlet---");

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.write("<h2>Welcome To LoginServlet</h2>");

		try
		{
		String username = request.getParameter("txtname");
		String password = request.getParameter("txtpwd");
		Customer cust = customerDao.validateCustomer(username, password);
		if(cust!=null)
		{
			System.out.println(cust);
			if(cust.getRole().equals("Admin"))
			{
				System.out.println(cust);			
				HttpSession session=request.getSession();
				System.out.println("---session created for valid cust----");
				session.setAttribute("custobj", cust);
				response.sendRedirect("management");
					
			}
			else
			{
			System.out.println(cust);			
			HttpSession session=request.getSession();
			System.out.println("---session created for valid cust----");
			session.setAttribute("custobj", cust);
			
			response.sendRedirect("products");
			}
		}
		else
		{
			response.sendRedirect("login.html");
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
