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

import com.dao.ProductDAO;
import com.pojo.Customer;
import com.pojo.Product;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/showdetails")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	ProductDAO prdDao;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session = request.getSession();
		Customer validCust=(Customer) session.getAttribute("custobj");
		
		pw.write("<br>Welcome Customer:"+validCust.getCname());
		
		
		ProductDAO prdDAO = (ProductDAO) session.getAttribute("prdDAO");
		String pname = request.getParameter("radioval");
		Product product = prdDAO.getPrdByName(pname);
		if(product!=null)
		{
			System.out.println(product);
			
			pw.write("</head><body>");
			pw.write("<h2>Product Details");
			pw.write("<p>Name: " + product.getPname() + "</p>");
			pw.write("<p>Description: " + product.getDescription() + "</p>");
			pw.write("<p>Price: " + product.getPrice() + "</p>");
			pw.write("<p>Quantity: " + product.getQuantity() + "</p>");
			pw.write("<input type='submit' value='AddToCart'>");
			
			
			pw.write("<form action='products' method='post'>");
			pw.write("<input type='submit' value='Back'>");
			pw.write("</form>");
			pw.write("</body>");
			pw.write("</html>");
			
		}
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
