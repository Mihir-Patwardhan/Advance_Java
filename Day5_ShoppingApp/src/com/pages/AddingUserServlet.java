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
 * Servlet implementation class AddingUserServlet
 */
@WebServlet("/registration")
public class AddingUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddingUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	CustomerDAO customerDao;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---inside init AddUserServlet----");
		customerDao = new CustomerDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.write("<h2>Welcome To AddUserServlet</h2>");

		try {
			String cname = request.getParameter("txtCname");
			String city = request.getParameter("txtCity");
			String email = request.getParameter("txtEmail");
			String username = request.getParameter("txtUserName");
			String password = request.getParameter("txtPwd");
			Customer cust=new Customer(cname,city,email,username,password);
			System.out.println("in servlet:"+cust);
			int newcust = customerDao.addNewCust(cust);
			if (newcust != 0) {
				HttpSession session = request.getSession();
				System.out.println("---session created for newcust----");
				session.setAttribute("NewCustomer", newcust);

				response.sendRedirect("complete");
			} else {
				response.sendRedirect("login.html");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
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
