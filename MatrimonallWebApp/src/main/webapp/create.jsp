<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="UTF-8">
		<title>Index Page</title>
		<link rel="stylesheet" href="style.css"/>
	</head>
	<body>
<%@page import="com.tutorials.jdbc.bo.Person"%>
		<%
			String exceptionMsg = (String) request.getAttribute("exceptionMsg");
			Person person = (Person) request.getAttribute("personForm");
			
			boolean isError = (null!=person);
			
			if(null!=exceptionMsg) {
		%>
				<div class="errorMsg">${exceptionMsg}</div>
		<%
			}
		%>
		<h1> SRIRASTU SUBHAMASTU </h1>
		<h3>RegisterationForm :</h3>
		<br>
		<form id="createForm" name="createForm" action="Create" method="post">
			<table border="1">
				<thead>
					<tr>
						<th>Field</th>
						<th>Value</th>
					</tr>				
				</thead>
				<tbody>	
					<tr>
						<td>First Name</td>
						<td>
							<input type="text" id="firstName" name="firstName"  
								placeholder="First Name" >
						</td>
					</tr>
					<tr>
						<td>Middle Name</td>
						<td>
							<input type="text" id="middleName" name="middleName" 
								placeholder="Middle Name" >
						</td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td>
							<input type="text" id="lastName" name="lastName"  
								placeholder="Last Name" >
						</td>
					</tr>
					<tr>
	                    <td>Gender</td>
	                    <td>
	                    	<input type="radio" name="gender" value="Male">Male
	                    	<input type="radio" name="gender" value="Female">Female
	                    </td>
                	</tr>
					<tr>
						<td>Age</td>
						<td>
							<input type="number" id="age" name="age" 
								min="18" max="52" step="1" size="20"
								placeholder="Your Age"
								required/>
						</td>
					</tr>
					<tr>
	                    <td>Email</td>
	                    <td><input type="Email" id="email" name="email" placeholder="Ex:abc@gmail.com" required></td>
	                </tr>
	                <tr>
	                    <td>Password</td>
	                    <td><input type="password" id="password" name="password" placeholder="password" required></td>
	                </tr>
					<tr>
	                    <td><label for="state">Select State</label></td>
                    	<td><select name="state" id="state" required>
                        <option value='' selected disabled hidden>Select an Option</option>
                        <option value="AndhraPradesh">AndhraPradesh</option>
                        <option value="Arunachal Pradesh">ArunachalPradesh</option>
                        <option value="Assam">Assam</option>
                        <option value="Bihar">Bihar</option>
                        <option value="Chhattisgarh">Chhattisgarh</option>
                        <option value="Goa">Goa</option>
                        <option value="Gujarat">Gujarat</option>
                        <option value="Haryana">Haryana</option>
                        <option value="Himachal Pradesh">HimachalPradesh</option>
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
	                    <td><input type="text" id="city" name="city" placeholder="city" required></td>
	                </tr>
	                <tr>
	                    <td>Postal Code</td>
	                    <td><input type="text" id="postalcode" name="postalcode" placeholder="postal code" required></td>
	                </tr>
	                <tr>
	                	<td>
	                		Address 
	                	</td>
	                	 <td>
	                	 	<input type="text" id="address" name="address" placeholder="Address" required>	
	                	 </td>
	                </tr>
	                <tr>
	                	<td>
                       		 Occupation
                    	</td>
                   		<td>
                       		 <input type="text" id="occupation" name="occupation" placeholder="occupation"  required>
                   		</td>
	                </tr>
					<tr>
	                	<td>
                       		 Income
                    	</td>
                   		<td>
                       		 <input type="text" id="income" name="income" placeholder="income" required>
                   		</td>
	                </tr>
	                <tr>
	                	 <td>
                       		 Religion
                    	</td>
                   		<td>
                       		<select name="religion" id="religion" required>
                       		<option value='' selected disabled hidden>Select an Option</option>
		                    <option value="Hindu">Hindu</option>
		                    <option value="Christian">Christian</option>
		                    <option value="Muslim">Muslim</option>
		                    <option value="Jain">Jain</option>
		                    <option value="Sikh">Sikh</option>
		                    <option value="Other">Other</option>
		                    <option value="NotApplicable">Not Apllicable</option> 
	                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Caste
                    	</td>
                   		<td>
                            <select name="caste" id="caste" required>
                            <option value='' selected disabled hidden>Select an Option</option>
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
                       		 <input type="text" id="subCaste" name="subCaste" placeholder="sub-caste"  required>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Hobbies
                    	</td>
                   		<td>
                       		 <input type="text" id="hobbies" name="hobbies" placeholder="hobbies"  required >
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 MaritalStatus
                    	</td>
                   		<td>
                            <select name="maritalStatus" id="maritalStatus" required>
                            <option value='' selected disabled hidden>Select an Option</option>
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
                            <select name="zodiacSign" id="zodiacSign" required>
                            <option value='' selected disabled hidden>Select an Option</option>
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
		                    <option value="NotApplicable">Not Apllicable</option>   
	                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Star
                    	</td>
                   		<td>
                       		<select name="star" id="star" required>
                       	    <option value='' selected disabled hidden>Select an Option</option>
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
		                    <option value="NotApplicable">Not Apllicable</option> 
	                    </select>  
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Height
                    	</td>
                   		<td>
                       		<select name="height" id="height" required>
                       		<option value='' selected disabled hidden>Select an Option</option>
		                    <option value="1">(100-110)cm</option>
		                    <option value="2">(111-120)cm</option>
		                    <option value="3">(121-130)cm</option>
		                    <option value="4">(131-140)cm</option>
		                    <option value="5">(141-150)cm</option>
		                    <option value="6">(151-160)cm</option>
		                    <option value="7">(161-170)cm</option>
		                    <option value="8">(171-180)cm</option>
		                    <option value="9">(181-190)cm</option>
		                    <option value="10">(191-200)cm</option>
		                    <option value="11">(200+)cm</option>  
	                    </select>
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Weight(kgs)
                    	</td>
                   		<td>
                       		 <input type="number" id="weight" name="weight" placeholder="weight in kgs"  required >
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Color
                    	</td>
                   		<td>
	                        <select name="color" id="color" required>
	                         	<option value='' selected disabled hidden>Select an Option</option>
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
                       		  	<option value='' selected disabled hidden>Select an Option</option>
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
                       		 <input type="text" id="fatherName" name="fatherName" placeholder="FatherName"  required >
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 MotherName
                    	</td>
                   		<td>
                       		 <input type="text" id="motherName" name="motherName" placeholder="MotherName"  required >
                   		</td>
	                </tr>
	                <tr>
	                	<td>
                       		 Smoking
                    	</td>
                   		<td>
	                        <select name="smoking" id="smoking" required>
	                         	<option value='' selected disabled hidden>Select an Option</option>
			                    <option value="YES">YES</option>
			                    <option value="NO">NO</option> 
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
	                         	<option value='' selected disabled hidden>Select an Option</option>
			                    <option value="YES">YES</option>
			                    <option value="NO">NO</option> 
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
	                            <option value='' selected disabled hidden>Select an Option</option>
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
	                            <option value='' selected disabled hidden>Select an Option</option>
			                    <option value="YES">YES</option>
			                    <option value="NO">NO</option>  
		                    </select>
                   		</td>
	                </tr>
					<tr>
						<td colspan="2">
							<input type="submit" name="Create" Value="Create"/>
						</td>
					</tr>				
				</tbody>
			</table>
		</form>
<%@ include file="footer.jsp" %>