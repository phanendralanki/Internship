package com.mvc.dao;

import com.mvc.util.DBConnection;
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

		
		String user_password = request.getParameter("user_password");
		String cpassword = request.getParameter("cpassword");
                HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		if (user_password != null && cpassword != null && user_password.equals(cpassword)) {

                    Connection con = null;
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				 con =DBConnection.createConnection();
				PreparedStatement pst = con.prepareStatement("update data set user_password = ? where user_email = ? ");
				pst.setString(1, user_password);
				pst.setString(2, (String) session.getAttribute("user_email"));

				int rs = pst.executeUpdate();
				if (rs > 0) {
                                    request.setAttribute("status", "resetSuccess");
                                    dispatcher = request.getRequestDispatcher("login.jsp");
                                } else {
                                    request.setAttribute("status", "resetFailed");
                                    dispatcher = request.getRequestDispatcher("register.jsp");
                                }
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

