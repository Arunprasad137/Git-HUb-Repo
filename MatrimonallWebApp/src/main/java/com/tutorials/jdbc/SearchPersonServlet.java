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
@WebServlet({ "/Search3" })
public class SearchPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPersonServlet() {
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
		//System.out.println("gender");
		String state = request.getParameter("state");
		
		String maritalStatus= request.getParameter("maritalStatus");
		
		
		String religion = request.getParameter("religion");
		if(religion=="null") {
			 religion ="";
		}
		String caste = request.getParameter("caste");
		if(caste=="null") {
			 caste =" ";
		}
		
		String drinking = request.getParameter("drinking");
		if(drinking=="null") {
			 drinking =" ";
		}
		String smoking = request.getParameter("smoking");
		if(smoking=="null") {
			 smoking=" ";
		}
		String diet = request.getParameter("diet");
		if(diet=="null") {
			 diet =" ";
		}
		String physicalStatus = request.getParameter("physicalStatus");
		if(physicalStatus=="null") {
			physicalStatus =" ";
		}
		
		System.out.println("Gender and State Parameter from the Request : " + gender+" " +state+" "
				+ maritalStatus +" " +religion +" "+ caste +" "+ drinking +" "+ smoking +" "+
				diet +" "+ physicalStatus);
		
		
	
		//Person person = PersonDAO.getPersonById(id);
		List<Person> searchPersonList = PersonDAO.searchPerson(gender,state,religion ,caste,maritalStatus, smoking, drinking, diet, physicalStatus);
		
		// 2. Store it in a way where the data is accessible in the JSP
		request.setAttribute("searchPersonList", searchPersonList);
		
		// 3. Forward / Delegate the control/flow the required JSP Page
		//request.getRequestDispatcher("view.jsp").forward(request, response);
		request.getRequestDispatcher("searchList.jsp").forward(request, response);	
	}
	

}
