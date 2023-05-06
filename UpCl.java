package max;

import com.edu.dao.UserDao;
import com.edu.daoI.UserDAOI;

public class UpCl {
public static void main(String[] args) {
	UserDao ob= new UserDAOI();
	   //boolean b = ob.update("8888", "baba", "7777777777");
	   if(ob.update("1222", "abhishek", "6200789045"))
	   {
		   System.out.println("successfull updated");
	   }
	   else {
		   System.out.println("faill");
	   }
	       /* if(ob.deleteData("1212"))
	        {
	        	System.out.println("successfully deleted");
	        }
	        else {
	        	System.out.println("faill");
	        }*/
	        
}
}
