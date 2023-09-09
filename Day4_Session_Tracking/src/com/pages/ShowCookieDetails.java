package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCookieDetails
 */
@WebServlet("/showcookie")
public class ShowCookieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCookieDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		pw.write("<h2>Welcome </h2>");
		pw.write("Welcome To Display Cookies");
		Cookie[] allCks = request.getCookies();
		for (Cookie ck : allCks) {
			if (ck.getName().equals("custname"))
			{
				pw.write("<br>Welcome Customer :"+ck.getValue());			
			}
			if(ck.getName().equals("custcity"))
			{
				pw.write("<br> Customer City:"+ck.getValue());
			}

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
