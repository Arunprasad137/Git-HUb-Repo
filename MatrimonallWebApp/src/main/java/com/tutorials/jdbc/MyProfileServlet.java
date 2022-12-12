package com.tutorials.jdbc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.tutorials.jdbc.bo.Person;
import com.tutorials.jdbc.dao.PersonDAO;

/**
 * Servlet implementation class ViewServlet
 */
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyProfileServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MyProfileServlet - doGet() invoked");
		HttpSession session = request.getSession();

		// 1. Get the data from Database
		try {
			PersonDAO.connectToDB();
		} catch (Exception e) {
			System.err.println("Exception occurred while connecting to the Database");
			System.err.println("Error Message : " + e.getMessage());
			// TODO: Remove this later, as this is not a good practice
			e.printStackTrace();

			// throw new ServletException(e.getMessage());
		}
           
		String email = (String) session.getAttribute("user");
		String password = (String) session.getAttribute("password");
		//String password = session("password");

		System.out.println("Id Parameter from the Request : " + email +"@"+ password);

		Person person = PersonDAO.loginPerson(email, password);

		// 2. Store it in a way where the data is accessible in the JSP
		session.setAttribute("person", person);
		

		// 3. Forward / Delegate the control/flow the required JSP Page
		request.getRequestDispatcher("myProfile.jsp").forward(request, response);
	}

}
