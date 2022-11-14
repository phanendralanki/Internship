package com.mvc.dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;



/**
 * Servlet implementation class ValidateOtp
 */
@WebServlet("/ValidateOtp")
public class ValidateOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
            //Here we are getting the otp that was Entered by the user
		int value=Integer.parseInt(request.getParameter("otp")); //this is the otp entered by the user
		HttpSession session=request.getSession();
		int otp=(int)session.getAttribute("otp");  //this is the otp that we sent to mail
//this otp is the otp that we stored in session i.e in ForgotPassword.java
		
		
		
		RequestDispatcher dispatcher=null;
		
		//if both i.e the user entered otp and the otp sent by user are equal then we will redirect to the 
                //newPassword.jsp
                //if the otp is wrong we will redirect to the enterotp by displaying the otp is wrong 
                //also we have created newPassword.jsp so that user can create the newpassword
                
		if (value==otp) 
		{
			
				request.setAttribute("user_email", request.getParameter("user_email"));
				request.setAttribute("status", "success");
                                 //also we have created newPassword.jsp so that user can create the newpassword
			  dispatcher=request.getRequestDispatcher("newPassword.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			request.setAttribute("message","wrong otp");
			
		   dispatcher=request.getRequestDispatcher("EnterOtp.jsp");
			dispatcher.forward(request, response);
		
		}
		
	}

}
