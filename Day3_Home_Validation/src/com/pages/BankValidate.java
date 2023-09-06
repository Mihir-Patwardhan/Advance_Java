package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.BankDal;
import com.pojo.Details;

/**
 * Servlet implementation class BankValidate
 */
@WebServlet("/BankValidate")
public class BankValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankValidate() {
        super();
        // TODO Auto-generated constructor stub
    }
    private BankDal bankDal;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		bankDal = new BankDal();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();


		String userName = request.getParameter("txtname");
		String pwd = request.getParameter("txtpwd");
		Details acc1 = bankDal.Validate(userName, pwd);
		
		
		if(acc1!=null)
		{
			System.out.println(acc1);
			pw.write("<br>Account:"+acc1);
			pw.write("<h2>Welcome To Banking Application");
			pw.write("<h3>Welcome :"+acc1.getName());
			pw.write("<h3>Balance:"+acc1.getBalance());
			pw.write("<hr>");
			RequestDispatcher rd=request.getRequestDispatcher("/Welcome");
			rd.forward(request, response);
			//rd.include(request, response);
			response.sendRedirect("Welcome");
		}
		else
		{
			System.out.println("---redirecting to Login.html---");
			response.sendRedirect("Login.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
