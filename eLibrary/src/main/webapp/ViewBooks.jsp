<%@page import="in.dac.dao.BookDetails"%>
<%@page import="java.util.List"%>
<%@page import="in.dac.db.DBOperations"%>
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
	<hr>
	<br>
	List of Books available in the eLibrary
	<br>
	<%
		DBOperations dops = new DBOperations();	
		dops.intializeDBConnection();
		List<BookDetails> books = dops.getAllBookDetails();
	%>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Published Year</th>
			<th>Price</th>
			<th>Author</th>
		</tr>
	<%
		for(BookDetails b : books)
		{
	%>
		<tr>
			<td><%=b.getBookid()%> </td>
			<td><%=b.getBookname() %></td>
			<td><%=b.getPublishedYear() %></td>
			<td><%=b.getPrice() %></td>
			<td><%=b.getAuthor() %></td>			
		</tr>		
	<% 			
		}
	%>
	</table>
</body>
</html>