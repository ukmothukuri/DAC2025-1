<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=getServletContext().getInitParameter("projectTitle") %></title>

<!-- This is the HTML Commenting section -->

<%-- This is the JSP Commenting section --%>

</head>
<body>
	<%= new Date()%>
	<%@include file="Header.jsp" %>
	<hr>
	<%@include file="Gallery.jsp" %>
	<hr>
	<%@include file="Content.jsp" %>
	<hr>
	<%@include file="Footer.jsp" %>
</body>
</html>