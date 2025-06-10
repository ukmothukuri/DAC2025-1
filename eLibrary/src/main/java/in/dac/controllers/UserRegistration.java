package in.dac.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import in.dac.dao.StudentDBOperations;
import in.dac.dao.UserDetails;
import in.dac.db.DBOperations;
import in.dac.entity.Student;
import in.dac.utils.Validations;

/**
 * Servlet implementation class UserRegistration
 */

@WebServlet(urlPatterns = "/register")
public class UserRegistration extends HttpServlet {
	
	String name;
	String email;
	String mobile;
	String password;
	String branch;
	int pass_year;
	Validations validate;
	DBOperations dbops;
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		PrintWriter out = response.getWriter();
		boolean status = false;
		name = request.getParameter("name");
		email = request.getParameter("email");
		mobile = request.getParameter("mobile");
		password = request.getParameter("password");
		branch = request.getParameter("branch");
		pass_year = Integer.parseInt(request.getParameter("pass_year"));
		
				
		// provide datavalidation
		validate = new Validations();
		if(validate.isUserNameValid(name) 
				&&validate.isUserEmailValid(email) 
				&&validate.isUserMobileValid(mobile) 
				&& validate.isUserPasswordValid(password)) 
		{

			Student s = new Student();
			s.setName(name);
			s.setEmail(email);
			s.setMobile(mobile);
			s.setPassword(password);
			s.setYearofpassing(pass_year);
			s.setBranch(branch);
			
			StudentDBOperations stdao = new StudentDBOperations();
			int rollnumber = stdao.createStudent(s);
			
			if(rollnumber != 0) {
				out.print("Registration is successful. Your roll number is :"+rollnumber);
			}					
			else {
				out.print("Problem encountered during registation. Please contact your admin");
			}
		}
		else 
		{
			out.println("Some of the feilds are invalid. Please check and try again");
			
		}
		
	}

}
