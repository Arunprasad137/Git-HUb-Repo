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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/Create")
public class CreateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("CreateServlet - doPost() called");
		
		/*response.setContentType("text/html");
		response.getWriter().write("Create Servlet invoked!");*/
		
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
		
		// 2. Collect all the Input data and prepare a Person object
		Person person = new Person();
		
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		
		String ageStr = request.getParameter("age");
		int age = ageStr!=null ? Integer.parseInt(ageStr) : 0;
		
		String gender = request.getParameter("gender");
		
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		
		String postalCodeStr = request.getParameter("postalcode");
		int postalCode = postalCodeStr!=null ? Integer.parseInt(postalCodeStr) : 0;
		
		String address = request.getParameter("address");
        String occupation = request.getParameter("occupation");
		
		String incomeStr = request.getParameter("income");
		int income = incomeStr!=null ? Integer.parseInt(incomeStr) : 0;
		
		String religion = request.getParameter("religion");
		String caste = request.getParameter("caste");
		String subCaste = request.getParameter("subCaste");
		String hobbies = request.getParameter("hobbies");
		String maritalStatus = request.getParameter("maritalStatus");
		String zodiacSign = request.getParameter("zodiacSign");
		String star = request.getParameter("star");
		
		String heightStr = request.getParameter("height");
		int height = heightStr!=null ? Integer.parseInt(heightStr) : 0;
		
		String weightStr = request.getParameter("weight");
		int weight = weightStr!=null ? Integer.parseInt(weightStr) : 0;
		
		String color = request.getParameter("color");
		String bloodType = request.getParameter("bloodType");
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		String smoking = request.getParameter("smoking");
		String drinking = request.getParameter("drinking");
		String diet = request.getParameter("diet");
		String physicalStatus = request.getParameter("physicalStatus");
		
		person.setFirstName(firstName);
		person.setMiddleName(middleName);
		person.setLastName(lastName);
		person.setAge(age);
		//validate that the gender is not null or empty, 
		//otherwise it will throw a NullPointerException
		person.setGender(gender);
		person.setEmail(email);
		person.setPassword(password);
		person.setState(state);
		person.setCity(city);
		person.setPostalCode(postalCode);
		person.setAddress(address);
		person.setOccupation(occupation);
		person.setIncome(income);
		person.setReligion(religion);
		person.setCaste(caste);
		person.setSubCaste(subCaste);
		person.setHobbies(hobbies);
		person.setMaritalStatus(maritalStatus);
		person.setZodiacSign(zodiacSign);
		person.setStar(star);
		person.setHeight(height);
		person.setWeight(weight);
		person.setColor(color);
		person.setBloodType(bloodType);
		person.setFatherName(fatherName);
		person.setMotherName(motherName);
		person.setSmoking(smoking);
		person.setDrinking(drinking);
		person.setDiet(diet);
		person.setPhysicalStatus(physicalStatus);
		
		System.out.println("Person Object prepared from the Request parameters : " + person);
		
		// 3. Insert a record into the Database Table
		//int recordsInserted = PersonDAO.createPerson(person);
		//int lastInsertedId = PersonDAO.createPerson(person);
		
		// 3.1 A different flavor of CreatePerson() method that would throw an Exception back
		int lastInsertedId = 0;
		String exceptionMsg = null;
		
		try {
			lastInsertedId = PersonDAO.createPersonFlavor1ThrowsException(person);
		}catch(Exception exception) {
			exceptionMsg = exception.getMessage();
			System.err.println("Exception occurred while inserting the data into the Database Table");
			System.err.println("Message : " + exceptionMsg);
		}
		
		// 4. Prepare the message to be shown to the User
		String message = null;
		String flag = null;
		
		if(lastInsertedId > 0) {
			//message = "Record inserted successfully";
			message = "Record inserted successfully, with the Id : " + lastInsertedId;
			flag = "success";
		} else {
			message = "Records was NOT inserted!";
			request.setAttribute("exceptionMsg", exceptionMsg);
			flag = "failure";
		}
		
		// 5. Store it in a way where the data is accessible in the JSP
		request.setAttribute("message", message);
		request.setAttribute("flag", flag);
	
		request.setAttribute("personForm", person);
		
		// 6. Forward / Delegate the control/flow the required JSP Page
		String url = null;

		if(lastInsertedId > 0) {
			person = PersonDAO.getPersonById(lastInsertedId);
			request.setAttribute("person", person);
			url = "status.jsp";
		}else {
			List<Person> personList = PersonDAO.listAll();
			request.setAttribute("personList", personList);
			//url = "list.jsp";
			url = "create.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
