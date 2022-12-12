<%@ page import="java.util.List, java.util.ArrayList,com.tutorials.jdbc.bo.Person" %>
<%@include file="header.jsp" %>
		<h1>List All Persons</h1>
		<%
			List<Person> searchPersonList = new ArrayList<>();
			Object obj = request.getAttribute("searchPersonList");
			if(null!=obj) {
				searchPersonList = (List<Person>) obj;
			}
		%>
		<%
			String message = (String) request.getAttribute("message");
			String flag = (String) request.getAttribute("flag");
			
			String exceptionMsg = (String) request.getAttribute("exceptionMsg");
			
			if(null!=message) {
		%>
				<div class="message <%= flag%>">${message}</div>
		<% 
			}
			if(null!=exceptionMsg) {
		%>
				<div class="errorMsg">${exceptionMsg}</div>
		<%
			}
		%>
		<h2>Total </h2>
		Total list of persons is : <%= searchPersonList.size() %>
		<%
			if(searchPersonList.size()<=0) {
		%>
				<div class=errorMsg>No records are available to display For the Search.</div>
		<%
			} else {
		%>
		<h3>Person List</h3>	
		<table border="1">
			<thead>
				<tr>
					<!--<td>Id</td>-->
					<td>First Name</td>
					<!--<td>Middle Name</td>-->
					<td>Last Name</td>
					<td>Age</td>
					<td>Gender</td>
					<td>Email</td>
					<!--<td>Password</td>-->
					<td>State</td>
					<td>City</td>
					<!--<td>PostalCode</td>-->
					<td>Address</td>
					<td>Occupation</td>
					<td>Income</td>
					<!--<td>Religion</td>
					<td>cast</td>
					<td>Sub-caste</td>
					<td>Hobbies</td>-->
				</tr>			
			</thead>
			<tbody>	
		<%				
			for(Person person : searchPersonList)
			{
				out.println("<tr>");
				/*out.println("<td class='center'>" + person.getId() + " " + 
				"<a href='View?id=" + person.getId() + "'>V " + "</a> | " +
				"</td>");*/
				out.println("<td class='center'>"+ 
						"<a href='View?firstName=" + person.getFirstName() + "'>"+ person.getFirstName()+ "</a>" +
						"</td>");
				//out.println("<td>" + person.getMiddleName() + "</td>");
				out.println("<td>" + person.getLastName() + "</td>");
				out.println("<td class='center'>" + person.getAge() + "</td>");
				out.println("<td>" + person.getGender() + "</td>");
				out.println("<td>" + person.getEmail() + "</td>");
				//out.println("<td>" + person.getPassword() + "</td>");
				out.println("<td>" + person.getState() + "</td>");
				out.println("<td>" + person.getCity() + "</td>");
				//out.println("<td>" + person.getPostalCode() + "</td>");
				out.println("<td>" + person.getAddress() + "</td>");
				out.println("<td>" + person.getOccupation() + "</td>");
				out.println("<td>" + person.getIncome() + "</td>");
				/*out.println("<td>" + person.getReligion() + "</td>");
				out.println("<td>" + person.getCaste() + "</td>");
				out.println("<td>" + person.getSubCaste() + "</td>");
				out.println("<td>" + person.getHobbies() + "</td>");*/
				out.println("</tr>");
			}			
		%>		
			</tbody>
		</table>
		<%
			}
		%>
<%@include file="footer.jsp" %>