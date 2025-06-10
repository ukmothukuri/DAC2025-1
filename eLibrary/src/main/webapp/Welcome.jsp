<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=getServletContext().getInitParameter("projectTitle") %></title>
</head>
<body>
	<div style="float:right">
		Welcome ... <%=session.getAttribute("usermail")%>
	</div>
	<br>
	<hr>
	<br>
	<%@include file="Header_Login.jsp" %>

	
</body>
</html>