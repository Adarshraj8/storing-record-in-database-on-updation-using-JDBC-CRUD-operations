package com.edu.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConUtility {
	private static Connection con;
   static {  
	   try {
	String url ="jdbc:postgresql://localhost:5432/feb23"; 
	Class.forName("org.postgresql.Driver");
	 con = DriverManager.getConnection(url,"postgres","123");
	
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
   public static Connection getConnnn()
   {
	   return con;
   }
   
   public static  String getDateTime()
   {
	   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date now = new Date();  
	           String date = formatter.format(now); 
	           return date;
   }
   public static int getUpdateID(Connection con,String uid)
   {
	   try {
    PreparedStatement ps= con.prepareStatement("select max(updateflag) as updateflag from empnew where uid=?");
    ps.setString(1, uid);
            ResultSet rs =ps.executeQuery();
            while(rs.next())
            {
            	int uf = rs.getInt("updateflag");
            	return uf+1;
            }
	} catch (Exception e) {
		
	}
	return 0;
   }
}
