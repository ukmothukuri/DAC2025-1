package in.dac.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import in.dac.config.DBOperations;
import in.dac.dao.UserDetails;
import in.dac.util.Validations;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet
{
	
	String username;
	String useremail;
	String usermobile;
	String userpassword;
	UserDetails user;
	Validations validate;
	DBOperations dbops;
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		PrintWriter out = response.getWriter();
		boolean status = false;
		username = request.getParameter("username");
		useremail = request.getParameter("useremail");
		usermobile = request.getParameter("usermobile");
		userpassword = request.getParameter("userpassword");
				
		// provide datavalidation
		validate = new Validations();
		if(validate.isUserNameValid(username) 
				&&validate.isUserEmailValid(useremail) 
				&&validate.isUserMobileValid(usermobile) 
				&& validate.isUserPasswordValid(userpassword)) 
		{
			user = new UserDetails();
			user.setUsername(username);
			user.setUseremail(useremail);
			user.setUsermobile(usermobile);
			user.setUserpassword(userpassword);
			
			
			dbops = new DBOperations();
			dbops.intializeDBConnection();
			status = dbops.registerUser(user);
			if(status) {
				out.print("Registration is successful");
			}					
			else {
				out.print("Problem encountered during registation. Please contact your admin");
			}
		}
		else 
		{
			out.println("");
			
		}
		
	}	
}
