package in.dac.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import in.dac.dao.UserDetails;
import in.dac.db.DBOperations;
import in.dac.utils.Validations;


/**
 * Servlet implementation class UserAuthentication
 */
@WebServlet(urlPatterns ="/login")
public class UserAuthentication extends HttpServlet {
	
	String userEmail;
	String userPassword;
	Validations validate;
	UserDetails user;
	DBOperations dops;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		userEmail = request.getParameter("useremail");
		userPassword = request.getParameter("userpassword");
		boolean status = false;
		validate = new Validations();
		if(validate.isUserEmailValid(userEmail) && validate.isUserPasswordValid(userPassword)) 
		{
			
			// check with the DB
			user = new UserDetails();
			user.setUseremail(userEmail);
			user.setUserpassword(userPassword);
			
			dops = new DBOperations();
			dops.intializeDBConnection();
			status = dops.checkUserLoginDetails(user);
			
			if(status)
			{
				// Session Creation
				HttpSession session = request.getSession(true);
				session.setAttribute("usermail", user.getUseremail());
				
//				RequestDispatcher dispatch = request.getRequestDispatcher("Welcome");			
//				request.setAttribute("Role", "user");							
//				dispatch.forward(request, response);	
				
				RequestDispatcher dispacth = request.getRequestDispatcher("Welcome.jsp");
				dispacth.forward(request, response);
				
				
			}else {
				response.sendRedirect("InvalidDetails.html");
			}
		}
		else {
			response.sendRedirect("InvalidDetails.html");
		}
		
	}

}
