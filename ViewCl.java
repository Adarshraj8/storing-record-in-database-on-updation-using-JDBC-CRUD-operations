package max;

import java.util.List;

import com.edu.bean.UserDTO;
import com.edu.dao.UserDao;
import com.edu.daoI.UserDAOI;

public class ViewCl {
public static void main(String[] args) {
	
	UserDao userDAO= new UserDAOI(); 
	 List<UserDTO> list = userDAO.viewDetail("1222");
	  for(UserDTO p:list) {
	  
	  System.out.println(p.getCountryName()+" - "+p.getName()+" - "+p.getPhone()+" - "+p.getRid()+" - "+p.getUid()+" "+p.getUflag()+" "+p.getDateTime());
	 }
	 
	    // UserDTO p = userDAO.viewDetail("7998");
//System.out.println(p.getCountryName()+" - "+p.getName()+" - "+p.getPhone()+" - "+p.getRid()+" - "+p.getUid()); 
}
}
