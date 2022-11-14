
package com.mvc.dao;

import com.mvc.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import java.sql.ResultSet;


public class RegisterDao {

    public RegisterDao(Connection createConnection) {
    }
    public String registerUser(RegisterBean registerBean){
        String user_name = registerBean.getUserName();
        String user_email = registerBean.getUserEmail();
        String mobile = registerBean.getMobile();
        String user_password = registerBean.getPassword();
        
        Connection con = null;
        PreparedStatement pst = null;
        try{
            con = DBConnection.createConnection();
            String query = "insert into data(user_name,user_email,mobile,user_password) values(?,?,?,?)";
            pst = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             pst.setString(1, user_name);
             pst.setString(2, user_email);
             pst.setString(3, mobile);
             pst.setString(4, user_password);
             
             int i= pst.executeUpdate();
             
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
        return "Oops.. Something went wrong there..!";
        }
}
      
    