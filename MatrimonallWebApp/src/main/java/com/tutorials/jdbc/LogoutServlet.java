package com.tutorials.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(description = "A Servlet to handle the Logout functionality", urlPatterns = { "/Logout" })
public class LogoutServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		/*PrintWriter out = response.getWriter();
		response.setContentType("text/html");*/
		//out.println("LogoutServlet invoked!");
		
		/* An alternate direct , faster approach
			but you may be wasting your bullets :) 
		 */
		//request.getSession().removeAttribute("user");
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		if(user!=null) {
			session.removeAttribute("user");
			request.setAttribute("message", "You have been logged out successfully!");			
		} else {
			request.setAttribute("errorMessage", "Looks like an unauthorized access to this page!");
		}
		request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
