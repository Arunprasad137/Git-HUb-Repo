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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("UpdateServlet - doPost() called");
		
		/*response.setContentType("text/html");
		response.getWriter().write("UpdateServlet invoked!");*/
		
		//1. Collect all the Input data and prepare a Person object
		Person person = new Person();
		
		String idStr = request.getParameter("id");
		if(null==idStr) {
			//TODO Revisit this later
			throw new ServletException("Missing Id value, can't update the row!");
		}
		
		int id = Integer.parseInt(idStr);
		
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
		
		String postalCodeStr = request.getParameter("postalCode");
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
		
		
		//2. Prepare the Person Object with the values obtained from Request
		person.setId(id);
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
		
		//3. Update the values in Database
		String exceptionMsg = null;
		try {
			PersonDAO.updatePerson(person);
		} catch (Exception exception) {
			exceptionMsg = exception.getMessage();
			System.err.println("Exception occurred while updating the data into the Database Table");
			System.err.println("Message : " + exceptionMsg);
			//TODO Remove later as it is not a good practice
			exception.printStackTrace();
		}
		
		//4. Prepare the response message  
		if(null!=exceptionMsg) {
			request.setAttribute("exceptionMsg", exceptionMsg);
		} else {
			request.setAttribute("message", "Record updated successfully!");
		}
		request.getSession().setAttribute("person", person);
		
		//5. Redirect/Delegate to the corresponding view 
		request.getRequestDispatcher("edit.jsp").forward(request, response);
		
		
	}

}
