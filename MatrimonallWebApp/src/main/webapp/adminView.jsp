<%@ page import="java.util.List, java.util.ArrayList,com.tutorials.jdbc.bo.Person" %>
<%@include file="adminHeader.jsp" %>
		<%
			String message = (String) request.getAttribute("message");
			String flag = (String) request.getAttribute("flag");
		
			if(null!=message) {
		%>
				<div class="message <%= flag%>">${message}</div>
		<% 
			}
		%>
		<h1>View Person</h1>
		<%
			Person person = (Person) request.getAttribute("person");
		
			if(null!=person) {
				session.setAttribute("person", person);
		%>
		<table border="1">
			<thead>
				<tr>
					<td>Field</td>
					<td>Value</td>
				</tr>				
			</thead>
			<tbody>	
				<tr>
					<td>Id</td>
					<td><%= person.getId() %></td>
				</tr>
				<tr>
					<td>FirstName</td>
					<td>${person.firstName}</td>
				</tr>
				<tr>
					<td>MiddleName</td>
					<td>${person.middleName}</td>
				</tr>
				<tr>
					<td>LastName</td>
					<td>${person.lastName}</td>
				</tr>
				<tr>
					<td>Age</td>
					<td>${person.age}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${person.email}</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>${person.password}</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>${person.gender}</td>
				</tr>
				<tr>
					<td>MaritalStatus</td>
					<td>${person.maritalStatus}</td>
				</tr>
				<tr>
					<td>Hobbies</td>
					<td>${person.hobbies}</td>
				</tr>
				<tr>
					<td>Height(cm)</td>
					<td>${person.height}</td>
				</tr>
				<tr>
					<td>Weight(kgs)</td>
					<td>${person.weight}</td>
				</tr>
				<tr>
					<td>Color</td>
					<td>${person.color}</td>
				</tr>
				<tr>
					<td>BloodGroup</td>
					<td>${person.bloodType}</td>
				</tr>
				<tr>
					<td>Religion</td>
					<td>${person.religion}</td>
				</tr>
				<tr>
					<td>Caste</td>
					<td>${person.caste}</td>
				</tr>
				<tr>
					<td>SubCaste</td>
					<td>${person.subCaste}</td>
				</tr>
				<tr>
					<td>ZodiacSign</td>
					<td>${person.zodiacSign}</td>
				</tr>
				<tr>
					<td>Star</td>
					<td>${person.star}</td>
				</tr>
				<tr>
					<td>State</td>
					<td>${person.state}</td>
				</tr>
				<tr>
					<td>City</td>
					<td>${person.city}</td>
				</tr>
				<tr>
					<td>PostalCode</td>
					<td>${person.postalCode}</td>
				</tr>
				<tr>
					<td>Address</td>
					<td>${person.address}</td>
				</tr>
				<tr>
					<td>Occupation</td>
					<td>${person.occupation}</td>
				</tr>
				<tr>
					<td>Income</td>
					<td>${person.income}</td>
				</tr>
				<tr>
					<td>FatherName</td>
					<td>${person.fatherName}</td>
				</tr>
				<tr>
					<td>MotherName</td>
					<td>${person.motherName}</td>
				</tr>
				<tr>
					<td>Smoking</td>
					<td>${person.smoking}</td>
				</tr>
				<tr>
					<td>Drinking</td>
					<td>${person.drinking}</td>
				</tr>
				<tr>
					<td>Diet</td>
					<td>${person.diet}</td>
				</tr>
				<tr>
					<td>PhysicalStatus</td>
					<td>${person.physicalStatus}</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="adminEdit.jsp">Edit</a> &nbsp;&nbsp;
						<a href="Delete?id=${person.id}">Delete</a>&nbsp;&nbsp;
					</td>
				</tr>			
			</tbody>
		</table>
		</div>
		<%
			} else {
		%>
				<div class=errorMsg>No matching records for the given Id - ${param.id}.</div>
		<%
			}
		%>
<%@include file="footer.jsp" %>