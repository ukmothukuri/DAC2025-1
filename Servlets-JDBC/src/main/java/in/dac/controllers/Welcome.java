package in.dac.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
		String useremail;
		String role;
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		out.print("Welcome "+useremail);
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			out.println("Session expired. Please login");
		}else{
			useremail = (String)session.getAttribute("usemail");
		}
				//useremail = request.getParameter("useremail");
		
		
		role = (String)request.getAttribute("Role");
		
		out.println("<br>");
		out.println("<hr>");
		if(role.equals("user")) {
			out.println("<a href=''>View Books</a>");
			out.println("<br>");
			out.println("<a href=''>Download Book</a>");
			out.println("<br>");
			out.println("<a href=''>Logout</a>");
		}
		if(role.equals("admin")) {
			out.println("<a href=''>Add Books</a>");
			out.println("<br>");
			out.println("<a href=''>View Books</a>");
			out.println("<br>");
			out.println("<a href=''>Update Books</a>");
			out.println("<br>");
			out.println("<a href=''>Logout</a>");
		}
	}

}
