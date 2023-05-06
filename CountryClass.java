package com.edu.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.edu.utility.ConUtility;

public class CountryClass {
 public static String getCountyCode(String code)
 {
	 String s=null;
	 ResultSet rs=null;
	 PreparedStatement ps=null;
	  /* Map<String,String> m=  new HashMap<String,String>();
	    m.put("91", "india");
	    m.put("92", "pakistan");
	    m.put("93","Bangladesh");
	    return (String)m.get(code);//ishai value ko yha sai bhejega sirf;*/
	Connection con = ConUtility.getConnnn();
	   try {
			
	                ps = con.prepareStatement("select cname from  world where id=?");
	                ps.setString(1,code);
	                rs = ps.executeQuery();
	               while(rs.next())
	               {
	            	s =  rs.getString("cname");
	               }
	            
		} catch (Exception e) {
		   e.printStackTrace();
		}
	   finally
	   {
		   try
		   {
		if(rs!=null)
		{
			rs.close();//resultset close
		}
		if(ps!=null)
		{
			ps.close();//statement close
		}
		   }
		   catch(SQLException hj)
		   {
			   
		   }
	   }
	     
	return s;
	    
 }

}
