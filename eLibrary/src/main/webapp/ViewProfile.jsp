<%@page import="in.dac.dao.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	// Write your DB operation to fetch the userdetails
	UserDetails user = null;

%>
<body>
	<div style="float:right">
		Welcome ... <%=session.getAttribute("usermail")%>
	</div>
	<br>
	<hr>
	<br>
	<%@include file="Header_Login.jsp" %>
	<hr>
	<br>
	User Profile:
	<form id="userProfileForm" action="#" method="post">
		Name: <input type="text" id="username" name="username" value="<%=user.getUsername()%>"> <br>
		Email:<input type="email" id="useremail" name="useremail" value="<%=user.getUseremail()%>" readonly="readonly"> <br>
		Mobile:<input type="tel" id="usermobile" name="usermobile" value="<%=user.getUsermobile()%>"> <br>		
		<button type="button" onclick="submitForm()">Update Profile</button>

	</form>
	
</body>
</html>