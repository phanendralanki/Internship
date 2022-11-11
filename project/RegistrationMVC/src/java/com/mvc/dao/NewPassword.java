package com.mvc.dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String newPassword = request.getParameter("user_password");
		String confPassword = request.getParameter("cpassword");
                HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

                    Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage?useSSL=false", "root",
						"root");
				PreparedStatement pst = con.prepareStatement("update data set user_password = ? where user_email = ? ");
				pst.setString(1, newPassword);
				pst.setString(2, (String) session.getAttribute("email"));

				int rs = pst.executeUpdate();
				if (rs > 0) {
                                    request.setAttribute("status", "resetFailed");
                                    dispatcher = request.getRequestDispatcher("login.jsp");
                                } else {
                                    request.setAttribute("status", "resetSuccess");
                                    dispatcher = request.getRequestDispatcher("login.jsp");
                                }
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

