//This file is responsible for sending the email


package com.mvc.dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            //you will get the email that was entered during the forget password i.e generating the otp
		String email = request.getParameter("user_email");  
		RequestDispatcher dispatcher = null;
		int otpvalue = 0;
		HttpSession mySession = request.getSession();
		
		if(email!=null || !email.equals("")) {
                    
			// sending otp
                        //Random class in java is used to generate random otp
                        
			Random rand = new Random();
                        
                        //with this given digits i.e six digit number it will generate the otp randomly
                        
			otpvalue = rand.nextInt(1255650);

			String to = email;// change accordingly
                        
			// Get the session object
                        
			Properties props = new Properties();
                        
                        //mail.smtp,host etc are the gmail configurations
                        
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
                        
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
                                    
                                    //here we have to store our username and password
					return new PasswordAuthentication("phanendralg12@gmail.com", "nqdaucozrebfcdkj");// Put your email
																									// id and
																									// password here
				}
			});
			// compose message - this section will contain what user will get in the message 
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));// change accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Hello"); //Hello is the subject check your mail
                                
				message.setText("your OTP is: " + otpvalue); //the text that we get
				// send message
				Transport.send(message); //Transport.send() will send the mail to the user
				System.out.println("message sent successfully");
			}

			catch (MessagingException e) {
				throw new RuntimeException(e);
			}
                        
                        /* After sending the otp we will redirect to EnterOtp.jsp*/
                        
			dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
			request.setAttribute("message","OTP is sent to your email id");
			//request.setAttribute("connection", con);
                        
                        //we will save the otp in this "session" to validate later 
                        //when user enters the otp then we will get this otp from session and we will compare the otp 
                        //entered by the user if the both otps are same we will reset this password otherwise we will get the
                        //message as incorrect otp that is why we are storing the otp in this session 
                        
			mySession.setAttribute("otp",otpvalue); 
			mySession.setAttribute("email",email); 
			dispatcher.forward(request, response);
                        
			//request.setAttribute("status", "success");
		}
		
	}

}
