<%@include file="adminHeader.jsp" %>
		<h1>Home Page of "SRIRASTU SUBHAMASTU"</h1>
		<%
			//String message = (String) request.getAttribute("message");
			String userInSession = (String) session.getAttribute("user");
		
			if(null!=userInSession) {
		%>			
				<div class="successMsg"><%= userInSession%></div>
		<%		
			}
		%>
<%@include file="footer.jsp" %>