<%@page import="com.tutorials.jdbc.bo.Person"%>
<%@ include file="adminHeader.jsp" %>
<br>
  <form method="get" action="Search6">	
	<label for="Gender">Gender : </label>
		<input  name="gender" value="Male" type="radio" class="radio_1" /> Male &nbsp;&nbsp;
		<input  name="gender" value="Female" type="radio" class="radio_1" /> Female
		
		<br><br> 
				
    <label for="state">State : </label>
        <select name="state" id = "state" required>
            <option value=''selected disabled hidden>Select an Option</option>
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
        </select>
        
        <br><br>
        
         <label for="religion">Religion : </label>
	         <select name="religion" id = "religion" >
	            <option value=''selected disabled hidden>Select an Option</option>
	            <option value="Not Applicable">Not Applicable</option>
			    <option value="Hindu">Hindu</option>
			    <option value="Christian">Christian</option>
			    <option value="Muslim">Muslim</option>
			    <option value="Jain">Jain</option>
			    <option value="Sikh">Sikh</option>
			    <option value="Other">Other</option> 
	         </select>
         
         <br><br>
         
          <label for="caste">Caste : </label>
	          <select name="caste" id = "caste" >
	          <option value='' selected disabled hidden>Select an Option</option>
		          <option value="General">General</option>
				  <option value="OBC">OBC</option>
				  <option value="OC">OC</option>
				  <option value="SC/ST">SC/ST</option>
				  <option value="Other">Other</option>
				  <option value="Not Applicable">Not Applicable</option>
			  </select>
		  
          <br><br>
          
          <label for="smoking">Smoking :</label>
		  <select name="smoking" id="smoking" >
		  	<option value='' selected disabled hidden>Select an Option</option>
			  <option value="YES">YES</option>
			  <option value="NO">No</option> 
			  <option value="OCCASIONALLY">OCCASIONALLY</option> 
		  </select>                    	                                     	
		  
		  <br><br>
		  
		  <label for="drinking">Drinking :</label>
		   <select name="drinking" id="drinking" >
		   	<option value='' selected disabled hidden>Select an Option</option>
			  <option value="YES">YES</option>
			  <option value="NO">No</option> 
			  <option value="OCCASIONALLY">OCCASIONALLY</option> 
		  </select>
		  
		  <br><br>
		  
		  <label for="diet">DIET :</label>
		  <select name="diet" id="diet" >
		  	<option value='' selected disabled hidden>Select an Option</option>
			  <option value="VEG">VEG</option>
			  <option value="NON-VEG">NON-VEG</option> 
			  <option value="BOTH">VEG & NON-VEG</option>
		  </select>
		  
		  <br><br>
		  
		  <label for="physicalStatus">Physically-Handicapped :</label>
		  <select name="physicalStatus" id="physicalStatus">
		  	 <option value='' selected disabled hidden>Select an Option</option>
			  <option value="YES">YES</option>
			  <option value="NO">No</option>
		  </select>
		  
		  <br><br>
		  
        <input type="submit" name="Search" Value="Search"/>
    </form>
    <%@ include file="footer.jsp" %>
     