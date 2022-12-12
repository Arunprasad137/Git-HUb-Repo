package com.tutorials.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tutorials.jdbc.dao.PersonDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "A Servlet to handle the Login Action", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("LoginServlet invoked!");
		
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//out.println("LoginServlet invoked! <br/>");
		
		//1. Get the Username
		String email = request.getParameter("email");
		System.out.println(email);
		
		//2. Get the password
		String password = request.getParameter("password");
		System.out.println(password);
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/matrimony?useSSL=false","root","Milvik@137");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM PERSON WHERE EMAIL = ? AND PASSWORD = ?");
			pst.setString(1,email);
			pst.setString(2,password);
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				session.setAttribute("user" , rs.getString("email"));
				session.setAttribute("password" , rs.getString("password"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("errorMessage", "Invalid Credentials. Try again!");
				dispatcher = request.getRequestDispatcher("login.jsp");
				System.out.println("Invalid Credentials."); 
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.err.println("Exception occurred while connecting to the Database");
			System.err.println("Error Message : " + e.getMessage());
			//TODO: Remove this later, as this is not a good practice
			e.printStackTrace();
			
			//throw new ServletException(e.getMessage());
		}
		
		/*String url = null;
		
		//3. Authenticate / validate 
		// Typically it goes to the DB and verifies
		// For the sake of simplicity, we verify the contents matching with one another for now.
		if(userName.equalsIgnoreCase(password)) {
			System.out.println("[INFO] Credentials matched!");
			//out.println("Success!");
			url = "/index.jsp";
			request.setAttribute("message", "Welcome " + userName);
			request.getSession().setAttribute("user", userName);
		} else {
			System.out.println("[ERR] Credentials Mismatch!");
			//out.println("Failure");
			request.setAttribute("errorMessage", "Invalid Credentials. Try again!");
			url = "/login.jsp";
		}
		
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}*/
	}
}
