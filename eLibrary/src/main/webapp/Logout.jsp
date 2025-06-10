<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
	Cookie[] cks = request.getCookies();
	for(Cookie c :  cks){
		c.setMaxAge(0);
	}
%>
</head>
<body>
	<h1>You have logged out successfully.</h1>
	<br>
	Please <a href="Login.jsp">Click here</a> to login again
</body>
</html>