
package com.mvc.dao;

import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


class UserLoginValidate {
    public static List<RegisterBean> getUsers(String email,String password){		
		List<RegisterBean>list = new ArrayList<>();
		//take a list to store the values which are in db
		 try{  
			Connection con=DBConnection.createConnection();  
			PreparedStatement ps=con.prepareStatement("select * from data where user_email=? and user_password=?");  
			ps.setString(1,email);  
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  				
				RegisterBean pObject=new RegisterBean(); 
				  
				pObject.setUserName(rs.getString(1)); //if the values exist in db then											
                                pObject.setMobile(rs.getString(2));
				pObject.setPassword(rs.getString(3));     // set them to setters and getters and them to list and return the list finally
				pObject.setUserEmail(rs.getString(4));
				list.add(pObject);
			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  		  
		return list;  //returns the list		
	}
}
