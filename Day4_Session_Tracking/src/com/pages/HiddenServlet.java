package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenServlet
 */
@WebServlet("/testhidden")
public class HiddenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HiddenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.write("<h2>Welcome To Sesion Tracking Using HiddenField: </h2>");

		pw.write("<h3>Welcome User:" + request.getParameter("txtname"));
		String strUser = request.getParameter("txtname");
		
		pw.write("<form action='showhidden' method='post'>");
		pw.write("<input type='text' name='txtactid'><br>");
		pw.write("<input type='hidden' name='txtusername' value='" + strUser + "'><br>");

		pw.write("<input type='submit' value='Next Page'><br>");
		pw.write("</form>");
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
