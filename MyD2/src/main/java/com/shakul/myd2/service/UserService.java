package com.shakul.myd2.service;

import com.shakul.myd2.model.User;

public interface UserService {

	User findById(String r_object_id);
	
	User findByUserLoginId(String strUserLoginId);
	
	public void saveUser(User user);

	void setDefaultValue(User user);

	public User getUserNameList(User searchUser);
}
