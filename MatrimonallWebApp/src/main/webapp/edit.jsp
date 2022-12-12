<%@ page import="java.util.List, java.util.ArrayList,com.tutorials.jdbc.bo.Person" %>
<%@include file="header.jsp" %>		
		<h1>Edit Person</h1>
		<%
			/* [17Oct2022] - Bug Fix - START */
			/* Issue : 
			   --------
			   Direct hit to Edit does not fetch the right object, instead
			   it reuses the object in session which was stored for the previous
			   operations.
			   Reason being,the id parameter being passed to this page from the
			   list.jsp, has never been considered/used. 
			 */
			Object idParam = request.getParameter("id");
			int id = -1;
			if(null!=idParam) {
				id = Integer.parseInt(idParam.toString());
				out.println("Id parameter passed is : " + id);
			}
			/* [17Oct2022] - Bug Fix - END */
			
			Person person = null;
			
			/* 1. See if the object is available in request scope */
			// from the /Edit (EditServlet)
			person = (Person) request.getAttribute("person");
			
			/* from the view.jsp page, see if it is available in Session scope */
			if(null==person) {
				person = (Person) session.getAttribute("person");	
			}			
		%>
		<%
			String message = (String) request.getAttribute("message");			
			
			String exceptionMsg = (String) request.getAttribute("exceptionMsg");
			
			if(null!=message) {
		%>
				<div class="message">${message}</div>
		<% 
			}
			if(null!=exceptionMsg) {
		%>
				<div class="errorMsg">${exceptionMsg}</div>
		<%
			}
			
			if(null==person) {
		%>
				<div class="errorMsg">No object available to edit!</div>
		<%		
			} else {
		%>	
				<form id="updateForm" name="UpdateForm" action="Update" method="post">
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
						<td>
							${person.id}
							<input type="hidden" name="id" value="${person.id}"/>
						</td>
					</tr>
					<tr>
	                    <td>Upload Profile Picture</td>
	                    <td>
	                    	<input type="file" name="pic" id="img">
	                    </td>
                    </tr>
					<tr>
						<td>First Name</td>
						<td>
							<input type="text" id="firstName" name="firstName" 
								placeholder="Your Name" value="${person.firstName}"
								required />
						</td>
					</tr>
					<tr>
						<td>Middle Name</td>
						<td>
							<input type="text" id="middleName" name="middleName" 
								placeholder="Your Name" value="${person.middleName}"/>
						</td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td>
							<input type="text" id="lastName" name="lastName" 
								placeholder="Your Name" value="${person.lastName}"
								required />
						</td>
					</tr>
					<tr>
	                    <td>Gender</td>
	                    <td>
	                    	<input type="radio" name="gender" id="gender" value="Male" 
							<%
								if(person.getGender().equals("Male")) {
									out.println(" checked");
								}
							%>>Male
							<input type="radio" name="gender" id="gender" value="Female"
							<%
								if(person.getGender().equals("Female")) {
									out.println(" checked");
								}
							%>>Female
	                    	<input type="radio" name="gender" id="gender" value="Custom"
	                    	<%
								if(person.getGender().equals("Custom")) {
									out.println(" checked");
								}
							%>>Custom
	                    </td>
                	</tr>
					<tr>
						<td>Age</td>
						<td>
							<input type="number" id="age" name="age" 
								min="1" max="100" step="1" size="5"
								placeholder="Your Age" value="${person.age}"
								required/>
						</td>
					</tr>
					<tr>
	                    <td>Email</td>
	                    <td>
	                    	<input type="Email" id="email" name="email" placeholder="Ex:abc@gmail.com" 
	                    	 value="${person.email}" required>
	                    </td>
	                </tr>
	                <tr>
	                    <td>Password</td>
	                    <td><input type="password" id="password" name="password" placeholder="password" value="${person.password}" required></td>
	                </tr>
					<tr>
	                    <td>State</td>
	                    <td><select name="state" id="state" required>
                        <option value="${person.state}">${person.state}</option>
                        <option value="AndhraPradesh">AndhraPradesh</option>
                        <option value="ArunachalPradesh">ArunachalPradesh</option>
                        <option value="Assam">Assam</option>
                        <option value="Bihar">Bihar</option>
                        <option value="Chhattisgarh">Chhattisgarh</option>
                        <option value="Goa">Goa</option>
                        <option value="Gujarat">Gujarat</option>
                        <option value="Haryana">Haryana</option>
                        <option value="HimachalPradesh">HimachalPradesh</option>
                        <option value="Jharkhand">Jharkhand</option>
                        <option value="Karnataka">Karnataka</option>
                        <option value="Kerala">Kerala</option>
                        <option value="madhyapradesh">Madhyapradesh</option>
                        <option value="Maharashtra">Maharashtra</option>
                        <option value="Manipur">Manipur</option>
                        <option value="Meghalaya">Meghalaya</option>
                        <option value="Mizoram">Mizoram</option>
                        <option value="Nagaland">Nagaland</option>
                        <option value="Odisha">Odisha</option>
                        <option value="Punjab">Punjab</option> 
                        <option value="Rajasthan">Rajasthan</option>
                        <option value="Sikkim">Sikkim</option>
                        <option value="TamilNadu">TamilNadu</option>
                        <option value="Telangana">Telangana</option>
                        <option value="Tripura">Tripura</option>
                        <option value="Uttarakhand">Uttarakhand</option>
                        <option value="UttarPradesh">UttarPradesh</option>
                        <option value="WestBengal">WestBengal</option>
                        <br>
                    </select>
	                    </td>
	                </tr>
	                <tr>
	                    <td>City</td>
	                    <td><input type="text" id="city" name="city" placeholder="city" required value="${person.city}"></td>
	                </tr>
	                <tr>
	                    <td>Postal Code</td>
	                    <td><input type="text" id="postalCode" name="postalCode" placeholder="postal code" required value="${person.postalCode}"></td>
	                </tr>
	                <tr>
	                	<td>
	                		Address 
	                	</td>
	                	 <td>
	                	 	<input type="text" id="address" name="address" placeholder="address" required value="${person.address}">	
	                	 </td>
	                </tr>
	                <tr>
	                	<td>
                       		 Occupation
                    	</td>
                   		<td>
                       		 <input type="text" id="occupation" name="occupation" placeholder="occupation"  required value="${person.occupation}">
                   		</td>
	                </tr>
					<tr>
	                	<td>
                       		 Income
                    	</td>
                   		<td>
                       		 <input type="text" id="income" name="income" placeholder="income" required value="${person.income}">
                   		</td>
	                </tr>
	                <tr>
	                	 <td>
                       		 Religion
                    	</td>
                   		<td>
                       		<select name="religion" id="religion" required>
                       		<option value="${person.religion}">${person.religion}</option>
		                    <option value="Not Applicable">Not Applicable</option>
		                    <option value="Hindu">Hindu</option>
		                    <option value="Christian">Christian</option>
		                    <option value="Muslim">Muslim</option>
		                    <option value="Jain">Jain</option>
		                    <option value="Sikh">Sikh</option>
		                    <option value="Other">Other</option>  
	                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Caste
                    	</td>
                   		<td>
                            <select name="caste" id="caste" required">
                            <option value="${person.caste}">${person.caste}</option>
		                    <option value="General">General</option>
		                    <option value="OBC">OBC</option>
		                    <option value="OC">OC</option>
		                    <option value="SC/ST">SC/ST</option>
		                    <option value="Other">Other</option>
		                    <option value="Not Applicable">Not Applicable</option>
	                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Sub-Caste
                    	</td>
                   		<td>
                       		 <input type="text" id="subCaste" name="subCaste" placeholder="sub-caste"  required value="${person.subCaste}">
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Hobbies
                    	</td>
                   		<td>
                       		 <input type="text" id="hobbies" name="hobbies" placeholder="hobbies"  required value="${person.hobbies}">
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 MaritalStatus
                    	</td>
                   		<td>
                            <select name="maritalStatus" id="maritalStatus" required">
                            <option value="${person.maritalStatus}">${person.maritalStatus}</option>
		                    <option value="Single">Single</option>
		                    <option value="Divorced">Divorced</option>
		                    <option value="Widower">widower</option>
		                    <option value="Widow">Widow</option>
		                    
	                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 ZodiacSign
                    	</td>
                   		<td>
                            <select name="zodiacSign" id="zodiacSign" required">
                            <option value="${person.zodiacSign}">${person.zodiacSign}</option>
		                    <option value="NotApplicable">Not Apllicable</option>
		                    <option value="Aries">Aries</option>
		                    <option value="Taurus">Taurus</option>
		                    <option value="Gemini">Gemini</option>
		                    <option value="Cancer">Cancer</option>
		                    <option value="Leo">Leo</option>
		                    <option value="Virgo">Virgo</option>
		                    <option value="Libra">Libra</option> 
		                    <option value="Scorpius">Scorpio</option>
		                    <option value="Sagittarius">Sagittarius</option>
		                    <option value="Capricornus">Capricorn</option>
		                    <option value="Aquarius">Aquarius</option>  
		                    <option value="Pisces">Pisces</option>   
	                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Star
                    	</td>
                   		<td>
                       		<select name="star" id="star" required">
                            <option value="${person.star}">${person.star}</option>
		                    <option value="NotApplicable">Not Apllicable</option>
		                    <option value="Aswini">Aswini</option>
		                    <option value="Bharani">Bharani</option>
		                    <option value="Krittika">Krittika</option>
		                    <option value="Rohini">Rohini</option>
		                    <option value="Mrigasira">Mrigasira</option>
		                    <option value="Aridra">Aridra</option>
		                    <option value="Punarvasu">Punarvasu</option>
		                    <option value="Pushya">Pushya</option>
		                    <option value="Aslesha">Aslesha</option>
		                    <option value="Makha">Makha</option>
		                    <option value="Purvaphalguni">Purvaphalguni</option>
		                    <option value="Uttaraphalguni">Uttaraphalguni</option>
		                    <option value="Hasta">Hasta</option>
		                    <option value="Chittra">Chittra</option>
		                    <option value="Swati">Swati</option>
		                    <option value="Visakha">Visakha</option>
		                    <option value="Anuradha">Anuradha</option>
		                    <option value="Jyeshta">Jyeshta</option>
		                    <option value="Moola">Moola</option>
		                    <option value="Purvashada">Purvashada</option>
		                    <option value="Uttarashada">Uttarashada</option>
		                    <option value="Sravana">Sravana</option>
		                    <option value="Dhanista">Dhanista</option>
		                    <option value="Satabisha">Satabisha</option>
		                    <option value="Purvabhadra">Purvabhadra</option>
		                    <option value="Uttarabhadra">Uttarabhadra</option>
		                    <option value="Revati">Revati</option>  
	                    </select>  
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Height(cm)
                    	</td>
                   		<td>
                       		<input type="number" id="height" name="height" 
								min="100" max="220" step="1" size="20"
								placeholder="Your Height in cm" value="${person.height}"
								required/>  
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Weight(kgs)
                    	</td>
                   		<td>
                       		 <input type="number" id="weight" name="weight" placeholder="weight in kgs"  required value="${person.weight}">
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Color
                    	</td>
                   		<td>
	                        <select name="color" id="color" required>
	                        	<option value="${person.color}">${person.color}</option>
			                    <option value="Dark">Dark</option>
			                    <option value="Fair">Fair</option> 
			               		<option value="Normal">Normal</option> 
		                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 BloodGroup
                    	</td>
                   		<td>
                       		 <select name="bloodType" id="bloodType" required>
                       		 	<option value="${person.bloodType}">${person.bloodType}</option>
			                    <option value="A +ve">A +ve</option>
			                    <option value="O +ve">O +ve</option>
			                    <option value="B +ve">B +ve</option>
			                    <option value="AB +ve">AB +ve</option>
			                    <option value="A -ve">A -ve</option>
			                    <option value="O -ve">O -ve</option>
			                    <option value="B -ve">B -ve</option>
			                    <option value="AB -ve">AB -ve</option> 
			                </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 FatherName
                    	</td>
                   		<td>
                       		 <input type="text" id="fatherName" name="fatherName" placeholder="FatherName"  required value="${person.fatherName}">
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 MotherName
                    	</td>
                   		<td>
                       		 <input type="text" id="motherName" name="motherName" placeholder="MotherName"  required value="${person.motherName}">
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Smoking
                    	</td>
                   		<td>
	                        <select name="smoking" id="smoking" required>
	                        	<option value="${person.smoking}">${person.smoking}</option>
			                    <option value="YES">YES</option>
			                    <option value="NO">No</option> 
			               		<option value="OCCASIONALLY">OCCASIONALLY</option> 
		                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Drinking
                    	</td>
                   		<td>
	                        <select name="drinking" id="drinking" required>
	                        	<option value="${person.drinking}">${person.drinking}</option>
			                    <option value="YES">YES</option>
			                    <option value="NO">No</option> 
			               		<option value="OCCASIONALLY">OCCASIONALLY</option> 
		                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 DIET
                    	</td>
                   		<td>
	                        <select name="diet" id="diet" required>
	                        	<option value="${person.diet}">${person.diet}</option>
			                    <option value="VEG">VEG</option>
			                    <option value="NON-VEG">NON-VEG</option> 
			               		<option value="BOTH">VEG & NON-VEG</option> 
		                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Physically-Handicapped
                    	</td>
                   		<td>
	                        <select name="physicalStatus" id="physicalStatus" required>
	                        	<option value="${person.physicalStatus}">${person.physicalStatus}</option>
			                    <option value="YES">YES</option>
			                    <option value="NO">No</option>  
		                    </select>
                   		</td>
	                </tr>
							<tr>
								<td colspan="2">
									<input type="submit" name="Update" Value="Update"/>
								</td>
							</tr>			
						</tbody>
					</table>
				</form>
		<% 		
			}
		%>
<%@include file="footer.jsp" %>