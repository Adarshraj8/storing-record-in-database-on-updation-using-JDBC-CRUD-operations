package com.edu.dao;

import java.util.List;

import com.edu.bean.UserDTO;

public interface UserDao {
	public boolean update(String uid,String name,String phone);
	public  boolean deleteData(String uid );
	public boolean insertData(UserDTO udto);
	public List<UserDTO> viewDetail(String uid);
	public List<UserDTO> viewDetail();
}
