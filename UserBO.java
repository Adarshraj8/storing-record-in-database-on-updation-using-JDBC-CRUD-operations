package com.edu.common;

import java.util.Random;

import com.edu.bean.UserBean;
import com.edu.bean.UserDTO;
import com.edu.dao.UserDao;
import com.edu.daoI.UserDAOI;

public class UserBO {
 	
  public boolean getUserDetail(UserBean ub)
  {
	  UserDao userdao=null;
	    UserDTO udto = new UserDTO();
	   String n = ub.getName();
	       n =  n.substring(0, 1).toUpperCase()+n.substring(1).toLowerCase();
	      udto.setName(n);
	      udto.setUid(ub.getUid());
	      udto.setPhone(ub.getPhone().substring(2 ));
	      // String code = ub.getPhone().substring(0,2);
	     udto.setCountryName(CountryClass.getCountyCode(ub.getPhone().substring(0,2)));
	     udto.setRid(rid());
	     userdao=new UserDAOI();
	     return  userdao.insertData(udto);
  }
 private  String rid()//ish method ki dependency get userdetail prr hai
   {
	 StringBuffer sb = new StringBuffer();
	   for(int i=0;i<=10;i++)
	   {
		   sb.append(new Random().nextInt(10));
	   }
	   return sb.toString().substring(0,4)+"XXXXX"+sb.substring(7);
   }
  public  String getUpdateRid()
  {
	  return rid();
  }
}
