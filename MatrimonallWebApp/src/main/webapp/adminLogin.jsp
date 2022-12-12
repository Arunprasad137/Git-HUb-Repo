<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JDBCWebApp | Login Page</title>
		<link rel="stylesheet" href="style.css"/>
	</head>
	<body>
        <%
			if(session.getAttribute("user")!=null) {
				request.getServletContext().getRequestDispatcher("/adminIndex.jsp").forward(request,response);
			}
		%>
		<%
			String errorMessage = (String) request.getAttribute("errorMessage");
			String message = (String) request.getAttribute("message");
		
			if(null!=errorMessage) {
		%>
				<div class="errorMsg"><%= errorMessage %></div>
		<%
			} else {
				if(null!=message) {
		%>	
				<div class=successMsg><%= message %></div>
		<%	
				}
			}
		%>
<h1>Welcome To "SRIRASTU SUBHAMASTU"</h1>
		<br>
		<h2>Admin Login Page :</h2>
		<div class="login">
			<form id="loginForm" name="LoginForm" method="post" action="AdminLogin2">
				<table>
					<thead>
						<tr>
							<td>Field</td>
							<td>Value</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								User Name : 
							</td>
							<td>
								<input type="text" id="email" name="email" 
										value="" size="20" required placeholder="email"/>
							</td>
						</tr>
						<tr>
							<td>
								Password : 
							</td>
							<td>
								<input type="password" id="password" name="password" 
								value="" size="20" required placeholder="Password"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" name="Login" Value="Login"/>
								<input type="reset" name="Reset" Value="Reset"/>
							</td>
						</tr>					
					</tbody>
				</table>
				<br>
			</form>
		</div>
		<hr/>
		<div class="footer">
			SRIRASTU SUBHAMASTU - v1.0 - <%= new java.util.Date() %>
		</div>
	</body>	
</html>