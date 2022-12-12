package com.tutorials.jdbc;

import java.io.IOException;
import java.util.List;

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
@WebServlet({ "/Search4" })
public class AdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("SearchPersonServlet - doGet() invoked");
		
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
		//List<Person> personSearchList = PersonDAO.searchPerson(gender,state);
		String gender = request.getParameter("gender");
		String state = request.getParameter("state");
		String religion = request.getParameter("religion");
		String caste = request.getParameter("caste");
		String maritalStatus= request.getParameter("maritalStatus");
		String smoking = request.getParameter("smoking");
		String drinking = request.getParameter("drinking");
		String diet = request.getParameter("diet");
		String physicalStatus = request.getParameter("physicalStatus");
		
		
		System.out.println("Gender and State Parameter from the Request : " + gender +state);
		
		//Person person = PersonDAO.getPersonById(id);
		List<Person> searchPersonList = PersonDAO.searchPerson(gender,state,religion ,caste,maritalStatus, smoking, drinking, diet, physicalStatus);
		
		// 2. Store it in a way where the data is accessible in the JSP
		request.setAttribute("searchPersonList", searchPersonList);
		
		// 3. Forward / Delegate the control/flow the required JSP Page
		//request.getRequestDispatcher("view.jsp").forward(request, response);
		request.getRequestDispatcher("adminSearchList.jsp").forward(request, response);	
	}
	

}
