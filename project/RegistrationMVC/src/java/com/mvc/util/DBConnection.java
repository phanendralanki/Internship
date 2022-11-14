package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection createConnection()
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/loginpage";
        String username = "root";
        String password = "user";
        System.out.println("In DBConnection.java class");
        
        try{
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Printing connection object "+con);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
