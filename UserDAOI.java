package com.edu.daoI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.bean.UserDTO;
import com.edu.common.UserBO;
import com.edu.dao.UserDao;
import com.edu.utility.ConUtility;

public class UserDAOI implements UserDao{
	
	public boolean update(String uid,String name,String phone)
	{
		 Connection con = ConUtility.getConnnn();
		 
		try {
			con.setAutoCommit(false);
			 UserDTO udto = new UserDTO();
	
			 PreparedStatement ps = con.prepareStatement("select * from empnew where uid=? and updateflag=?");
			 ps.setString(1, uid);
			 ps.setInt(2, 0);
			 ResultSet rs  = ps.executeQuery();
			 while(rs.next())
			 {
                    String country= rs.getString("country");
	            	udto.setCountryName(country==null ? "World" :country);
	            	udto.setName(rs.getString("name"));
	            	udto.setPhone(rs.getString("phone"));
	            	udto.setRid(rs.getString("rid"));
	            	udto.setUid(rs.getString("uid"));
			 }
			 
	 ps = con.prepareStatement("update empnew set phone = ?,name = ? where uid=? and updateflag=?");
              ps.setString(1, phone);
              ps.setString(2, name);
              ps.setString(3, uid);
              ps.setInt(4, 0);
              
             int i = ps.executeUpdate();
             if(i>0) 
             {
            	 ps = con.prepareStatement("insert into empnew values(?,?,?,?,?,?,?)");
	                 ps.setString(1,new UserBO().getUpdateRid());
	                 ps.setString(2,udto.getUid());
	                 ps.setString(3,udto.getPhone());
	                 ps.setString(4,udto.getName());
	                 ps.setString(5,udto.getCountryName());
	                 ps.setInt(6, ConUtility.getUpdateID(con, uid));
	                 ps.setString(7, ConUtility.getDateTime());
	                 int j = ps.executeUpdate();
	                 if(j>0) {
	                 con.commit();
	                return true;
	                 }
             }
             else {
            	 con.rollback();
             }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public  boolean deleteData(String uid )
	{
		try {
			Connection con = ConUtility.getConnnn();
			PreparedStatement ps =  con.prepareStatement("delete from empnew where uid = ?");
			ps.setString(1, uid);
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
 public boolean insertData(UserDTO udto)
 {      
	 try {
		        Connection con = ConUtility.getConnnn();
	PreparedStatement ps = con.prepareStatement("insert into empnew values(?,?,?,?,?,?,?)");
	                 ps.setString(1,udto.getRid());
	                 ps.setString(2,udto.getUid());
	                 ps.setString(3,udto.getPhone());
	                 ps.setString(4,udto.getName());
	                 ps.setString(5,udto.getCountryName());
	                 ps.setInt(6, 0);
	                 ps.setString(7, ConUtility.getDateTime());
	                 int i = ps.executeUpdate();
	                  if(i>0)
	                	  return true;
	} catch (Exception e) {
	  e.printStackTrace();
	}
	  
	return false;
}
 
 public List<UserDTO> viewDetail(String uid)
 {
	    List<UserDTO> list = new ArrayList<UserDTO>();
	 
	 Connection con = ConUtility.getConnnn();
		 try {
			
	  PreparedStatement ps= con.prepareStatement("select * from empnew where uid like '"+uid+"%'order by updateflag");
	     //    ps.setString(1, "%uid%");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {   
	            	UserDTO udto = new UserDTO();
	            	String rid= rs.getString("rid");
	            	String ud= rs.getString("uid");
	            	String phone= rs.getString("phone");
	            	String name= rs.getString("name");
	            	String country= rs.getString("country");
	            	 udto.setUflag(""+rs.getInt("updateflag"));
	            	 udto.setDateTime(rs.getString("modifydate"));
	            	udto.setCountryName(country==null ? "World" :country);
	            	udto.setName(name);
	            	udto.setPhone(phone);
	            	udto.setRid(rid);
	            	udto.setUid(ud);
	            	list.add(udto);
	            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return list;
 }
 public List<UserDTO> viewDetail()
 {
	          List<UserDTO> l = new ArrayList<UserDTO>();
	 try {
		 Connection con = ConUtility.getConnnn();
  PreparedStatement ps= con.prepareStatement("select * from empnew where updateflag =?");
         ps.setInt(1, 0);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {   
            	UserDTO udto = new UserDTO();
            	String rid= rs.getString("rid");
            	String uid= rs.getString("uid");
            	String phone= rs.getString("phone");
            	String name= rs.getString("name");
            	String country= rs.getString("country");
            	udto.setCountryName(country==null ? "World" :country);
            	udto.setName(name);
            	udto.setPhone(phone);
            	udto.setRid(rid);
            	udto.setUid(uid);
            	l.add(udto);
            }
	} catch (Exception e) {
		e.printStackTrace();
	}
	return l;
 }
}
