package com.shakul.myd2.dao;



import com.shakul.myd2.model.User;

public interface UserDao {

	User findById(String r_object_id);
	
	User findByUserLoginId(String strUserLoginId);
	
	public void saveUser(User user);

	void setDafaultValue(User user);

	public User getUserNameList(User searchUser);
}
