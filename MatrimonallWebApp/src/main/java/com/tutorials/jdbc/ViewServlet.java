package com.tutorials.jdbc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tutorials.jdbc.bo.Person;
import com.tutorials.jdbc.dao.PersonDAO;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet({ "/ViewServlet", "/View" })
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("ViewServlet - doGet() invoked");
		
		// 1. Get the data from Database 
		try {
			PersonDAO.connectToDB();
		} catch (Exception e) {
			System.err.println("Exception occurred while connecting to the Database");
			System.err.println("Error Message : " + e.getMessage());
			//TODO: Remove this later, as this is not a good practice
			e.printStackTrace();
			
			//throw new ServletException(e.getMessage());
		}
		
		//int id =1;
		String firstName = request.getParameter("firstName");
		
		/*if(null!=idStr && idStr.trim().length()>0) {
			id = Integer.parseInt(idStr);
		}*/
		
		System.out.println("FN Parameter from the Request : " + firstName);
		
		Person person = PersonDAO.getPersonByName(firstName);
		
		// 2. Store it in a way where the data is accessible in the JSP
		request.setAttribute("person", person);
		
		// 3. Forward / Delegate the control/flow the required JSP Page
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
