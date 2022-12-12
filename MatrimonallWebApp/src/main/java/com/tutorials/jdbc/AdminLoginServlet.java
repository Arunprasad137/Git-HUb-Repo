package com.tutorials.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "A Servlet to handle the Login Action", urlPatterns = { "/AdminLogin" })
public class AdminLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("AdminLoginServlet invoked!");
		
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//out.println("LoginServlet invoked! <br/>");
		
		//1. Get the Username
		String email = request.getParameter("email");
		
		//2. Get the password
		String password = request.getParameter("password");
		
		String url = null;
		
		//3. Authenticate / validate 
		// Typically it goes to the DB and verifies
		// For the sake of simplicity, we verify the contents matching with one another for now.
		if(email.equalsIgnoreCase(password)) {
			System.out.println("[INFO] Credentials matched!");
			//out.println("Success!");
			url = "/adminIndex.jsp";
			request.setAttribute("message", "Welcome " + email);
			request.getSession().setAttribute("user", email);
		} else {
			System.out.println("[ERR] Credentials Mismatch!");
			//out.println("Failure");
			request.setAttribute("errorMessage", "Invalid Credentials. Try again!");
			url = "/adminLogin.jsp";
		}
		
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
