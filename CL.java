package max;

import java.util.Scanner;

import com.edu.bean.UserBean;
import com.edu.common.UserBO;

public class CL {
 public static void main(String[] args) {
	   Scanner s = new Scanner(System.in);
	   System.out.println("Enter UID");
	     String uid=  s.nextLine();
	     System.out.println("Enter Name");
	     String n =  s.nextLine();
	     System.out.println("Enter Phone");
	     String p=  s.nextLine();
	       UserBean ub= new UserBean();
	       ub.setName(n);
	       ub.setPhone(p);
	       ub.setUid(uid);
	      UserBO userBO = new UserBO();
	      if(userBO.getUserDetail(ub))
	      {
	    	  System.out.println("Success");
	      }
	      else {
	    	  System.out.println("fail");
	      }
}
}
