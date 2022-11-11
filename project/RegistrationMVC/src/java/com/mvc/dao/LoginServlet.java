package com.mvc.dao;

import com.mvc.bean.RegisterBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try {
            String email = req.getParameter("user_email");
            //getting userid and password from user 
            String password = req.getParameter("user_password");

            RegisterBean pObject = new RegisterBean();

            //setting them to setters and getters
            pObject.setUserEmail(email);
            pObject.setPassword(password);
            List<RegisterBean> list = new ArrayList<>(); //take a list

            list = UserLoginValidate.getUsers(email, password); //send the values id and password to vadlidate class of getUsers method and storing the resultset in list
            if (!(list.isEmpty())) {
                //if list has some values then you are logged in
                

                req.getRequestDispatcher("index.jsp").include(req,resp);
                
            } else {
                //if no values are found then the User does not exist
                req.getRequestDispatcher("login.jsp").include(req, resp);
                out.print("<p align='center'>User Does Not Exist! Please Register");
                out.print("<a href='index.jsp'>Register Here</a></p>");
            }
        } catch (Exception e) {
            req.getRequestDispatcher("login.jsp").include(req, resp);
            out.print("<p>Please Enter Valid Details To Login</p>");
//executes when user enters invalid details

        }
    }

}
