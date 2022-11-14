package com.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//packages code 
import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;
import com.mvc.util.DBConnection;

public class registerservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            String user_name = request.getParameter("user_name");
            String user_email = request.getParameter("user_email");
            String mobile = request.getParameter("mobile");
            String user_password = request.getParameter("user_password");

            RegisterBean registerBean = new RegisterBean();
            //Using Java Beans - An easiest way to play with group of related data
            registerBean.setUserName(user_name);
            registerBean.setUserEmail(user_email);
            registerBean.setMobile(mobile);
            registerBean.setPassword(user_password);

            RegisterDao registerDao = new RegisterDao(DBConnection.createConnection());

            String userRegistered = registerDao.registerUser(registerBean);

            if (userRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
            {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else //On Failure, display a meaningful message to the User.
            {
                request.setAttribute("errMessage", userRegistered);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
