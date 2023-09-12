package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.write("<h1>Welcome to Registraion Page</h1>");
		pw.write("<form action='registration' method='post'>");
		pw.write("<center><table><caption><strong>Registraion</strong></caption>");
				
		pw.write("<tr><td>Name</td><td><input type='text' name='txtCname'> </td></tr><tr>");
		pw.write("<tr><td>City</td><td><input type='text' name='txtCity'> </td></tr><tr>");
		pw.write("<tr><td>Email</td><td><input type='email' name='txtEmail'> </td></tr><tr>");
		pw.write("<tr><td>Username</td><td><input type='text' name='txtUserName'> </td></tr><tr>");
		pw.write("<td>Password</td><td><input type='password' name='txtPwd'></td></tr>");
		pw.write("</table><tr>");
		pw.write("<td><input type='submit'></center></td></tr></form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
